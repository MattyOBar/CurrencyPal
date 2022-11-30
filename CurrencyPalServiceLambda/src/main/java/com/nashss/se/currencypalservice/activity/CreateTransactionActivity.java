package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.CreateTransactionRequest;
import com.nashss.se.currencypalservice.activity.results.CreateTransactionResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.CurrencyDAO;
import com.nashss.se.currencypalservice.dynamodb.DAO.TransactionDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Transaction;
import com.nashss.se.currencypalservice.models.TransactionModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.UUID;

import javax.inject.Inject;

public class CreateTransactionActivity {
    private final Logger log = LogManager.getLogger();
    private final TransactionDAO transactionDAO;

    private final CurrencyDAO currencyDAO;

    /**
     * Constructor for the CreateTransactionActivity.
     * @param transactionDao the TransactionDAO
     * @param currencyDAO the currencyDAO
     */
    @Inject
    public CreateTransactionActivity(TransactionDAO transactionDao, CurrencyDAO currencyDAO) {
        this.transactionDAO = transactionDao;
        this.currencyDAO = currencyDAO;
    }

    /**
     * This method handles the request for creating a new transaction.
     * @param createTransactionRequest The incoming request
     * @return the outgoing result
     */
    public CreateTransactionResult handleRequest(final CreateTransactionRequest createTransactionRequest) {
        log.info("Received CreateTransactionRequest {}", createTransactionRequest);
        String transactionId = createTransactionId();
        String customerName = createTransactionRequest.getCustomerName();
        String startCurrency = createTransactionRequest.getStartCurrency();
        String endCurrency = createTransactionRequest.getEndCurrency();
        double startAmount = createTransactionRequest.getStartAmount();
        double conversionRate = currencyDAO.getCurrency(endCurrency).getCurrentRate();
        double endAmount = startAmount * conversionRate;

        Transaction transaction = new Transaction();
        transaction.setTransactionId(transactionId);
        transaction.setCustomerName(customerName);
        transaction.setStartCurrency(startCurrency);
        transaction.setEndCurrency(endCurrency);
        transaction.setStartAmount(startAmount);
        transaction.setEndAmount(endAmount);

        transactionDAO.saveTransaction(transaction);
        TransactionModel transactionModel = new ModelConverter().toTransactionModel(transaction);

        return CreateTransactionResult.builder()
                .withTransactionModel(transactionModel)
                .build();
    }

    private String createTransactionId() {
        String transactionId = UUID.randomUUID().toString().substring(0, 5);
        return transactionId;
    }

}
