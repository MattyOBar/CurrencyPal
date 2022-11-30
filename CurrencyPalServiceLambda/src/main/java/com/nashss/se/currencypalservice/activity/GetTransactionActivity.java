package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.GetTransactionRequest;
import com.nashss.se.currencypalservice.activity.results.GetTransactionResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.TransactionDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Transaction;

import com.nashss.se.currencypalservice.models.TransactionModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

/**
 * Implementation of the GetTransaction for the CurrencyPal .
 *
 * This API allows the operator to get a specific currency.
 */

public class GetTransactionActivity {

    private final Logger log = LogManager.getLogger();
    private final TransactionDAO transactionDAO;
    /**
     * Instantiates a new GetTransactionActivity Object.
     *
     * @param transactionDAO transactionDAO to access the currency table.
     */
    @Inject
    public GetTransactionActivity(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    /**
     * This method handles the incoming request by retrieving the Transaction from the data base.
     * @param getTransactionRequest the request object containing the TransactionType.
     * @return getTransactionResult the result object containing the API defined {@link TransactionModel}.
     */
    public GetTransactionResult handleRequest(final GetTransactionRequest getTransactionRequest) {
        log.info("Received GetCurrencyRequest {}", getTransactionRequest);
        String transactionId = getTransactionRequest.getTransactionId();
        Transaction transaction = transactionDAO.getTransaction(transactionId);
        TransactionModel transactionModel = new ModelConverter().toTransactionModel(transaction);
        return GetTransactionResult.builder()
                .withTransaction(transactionModel)
                .build();
    }
}
