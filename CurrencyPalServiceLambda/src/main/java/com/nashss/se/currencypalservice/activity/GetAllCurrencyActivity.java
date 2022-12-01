package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.GetAllCurrencyRequest;
import com.nashss.se.currencypalservice.activity.results.GetAllCurrencyResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.CurrencyDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.models.CurrencyModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
/**
 * Implementation of the GetAllCurrencyActivity for the CurrencyPal.
 *
 */
public class GetAllCurrencyActivity {
    private final Logger log = LogManager.getLogger();

    private final CurrencyDAO currencyDAO;

    /**
     * Instantiates a new GetCurrencyActivity Object.
     *
     * @param currencyDAO CurrencyDAO to access the currency table.
     */
    @Inject
    public GetAllCurrencyActivity(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }
    /**
     * This method handles the incoming request by retrieving the playlist from the data base.
     * @param getAllCurrencyRequest the request object containing the CurrencyType.
     * @return getAllCurrencyResult the result object containing the API defined {@link CurrencyModel}.
     */
    public GetAllCurrencyResult handleRequest(final GetAllCurrencyRequest getAllCurrencyRequest) {
        log.info("Recieved GetAllCurrencyRequest {}", getAllCurrencyRequest);
        List<Currency> currencyList = currencyDAO.getAllCurrency();
        List<CurrencyModel> currencyModelList = new ArrayList<>();
        for (Currency currency : currencyList) {
            CurrencyModel currencyModel = new ModelConverter().toCurrencyModel(currency);
            currencyModelList.add(currencyModel);
        }
        return GetAllCurrencyResult.builder()
                .withCurrencies(currencyModelList)
                .build();
    }
}
