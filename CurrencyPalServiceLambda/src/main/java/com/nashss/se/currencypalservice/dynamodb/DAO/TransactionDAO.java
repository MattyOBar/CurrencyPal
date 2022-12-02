package com.nashss.se.currencypalservice.dynamodb.DAO;

import com.nashss.se.currencypalservice.dynamodb.models.Transaction;
import com.nashss.se.currencypalservice.exceptions.TransactionNotFoundException;
import com.nashss.se.currencypalservice.metrics.MetricsConstants;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class TransactionDAO {
    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;
    /**
     * Instantiates a TransactionDao object.
     * @param dynamoDBMapper the link used to interact with the Currency table
     * @param metricsPublisher the link used to record metrics
     */
    @Inject
    public TransactionDAO(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    /**
     * Makes a DynamoDB call to retrieve the specified transaction.
     * @param transactionId the parameter that indicates the specified transaction.
     * @return the transaction Object retrieved from DynamoDB.
     */
    public Transaction getTransaction(String transactionId) {
        Transaction transaction = this.dynamoDBMapper.load(Transaction.class, transactionId);
        if (transaction ==  null) {
            metricsPublisher.addCount(MetricsConstants.GETTRANSACTION_TRANSACTIONNOTFOUND_COUNT, 1);
            throw new TransactionNotFoundException("Could not find transaction with id: " + transactionId);
        }
        metricsPublisher.addCount(MetricsConstants.GETTRANSACTION_TRANSACTIONNOTFOUND_COUNT, 0);
        return transaction;
    }

    public List<Transaction> getAllTransaction() {
        return dynamoDBMapper.scan(Transaction.class, new DynamoDBScanExpression());
    }
    /**
     * Makes a DynamoDB call to retrieve and update a specified Transaction.
     * @param transaction the parameter used to specify the transaction to be updated
     * @param endAmount the parameter used to specify the updated result of the transaction.
     * @return the new updated transaction object
     */
    public Transaction updateTransaction(Transaction transaction, double endAmount) {
        transaction.setEndAmount(endAmount);
        this.dynamoDBMapper.save(transaction);
        return transaction;
    }

    /**
     * Makes a DynamoDB call to save the given transaction.
     *
     * @param transaction the parameter used to specify the transaction to be updated.
     */
    public void saveTransaction(Transaction transaction) {
        this.dynamoDBMapper.save(transaction);
    }
}
