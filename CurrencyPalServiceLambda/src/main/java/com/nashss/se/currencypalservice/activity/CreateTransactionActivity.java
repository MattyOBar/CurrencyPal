package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.CreateTransactionRequest;
import com.nashss.se.currencypalservice.activity.results.CreateTransactionResult;
import com.nashss.se.currencypalservice.dynamodb.DAO.CurrencyDAO;
import com.nashss.se.currencypalservice.dynamodb.DAO.TransactionDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.UUID;

public class CreateTransactionActivity {
    private final Logger log = LogManager.getLogger();
    private final TransactionDAO transactionDAO;

    private final CurrencyDAO currencyDAO;

    @Inject
    public CreateTransactionActivity(TransactionDAO transactionDao, CurrencyDAO currencyDAO){
        this.transactionDAO = transactionDao;
        this.currencyDAO = currencyDAO;
    }

    public CreateTransactionResult handleRequest(final CreateTransactionRequest createTransactionRequest) {
        log.info("Received CreateTransactionRequest {}", createTransactionRequest);
        String transactionId = createTransactionId();
        String customerName = createTransactionRequest.getCustomerName();
        String startCurrency = createTransactionRequest.getStartCurrency();
        String endCurrency = createTransactionRequest.getEndCurrency();
        double startAmount = createTransactionRequest.getStartAmount();
        double conversionRate = currencyDAO.getCurrency(startCurrency).getCurrentRate();
        double endRate = startAmount * conversionRate;

    }

    private String createTransactionId(){
        String transactionId = UUID.randomUUID().toString().substring(0,5);
        return transactionId;
    }

}
