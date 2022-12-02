package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.GetAllTransactionRequest;
import com.nashss.se.currencypalservice.activity.results.GetAllTransactionResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.TransactionDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Transaction;
import com.nashss.se.currencypalservice.models.TransactionModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class GetAllTransactionActivity {
    private final Logger log = LogManager.getLogger();

    private final TransactionDAO transactionDAO;

    /**
     * Instantiates a new GetAllTransactionActivity Object.
     *
     * @param transactionDAO TransactionDAO to access the currency table.
     */
    @Inject
    public GetAllTransactionActivity(TransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }
    /**
     * This method handles the incoming request by retrieving the playlist from the data base.
     * @param getAllTransactionRequest the request object containing the CurrencyType.
     * @return getAllTransactionResult the result object containing the API defined {@link TransactionModel}.
     */
    public GetAllTransactionResult handleRequest(final GetAllTransactionRequest getAllTransactionRequest) {
        log.info("Received GetAllTransactionRequest {}", getAllTransactionRequest);
        List<Transaction> transactionList = transactionDAO.getAllTransaction();
        List<TransactionModel> transactionModelList = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            TransactionModel transactionModel = new ModelConverter().toTransactionModel(transaction);
            transactionModelList.add(transactionModel);
        }
        return GetAllTransactionResult.builder()
                .withTransaction(transactionModelList)
                .build();
    }

}
