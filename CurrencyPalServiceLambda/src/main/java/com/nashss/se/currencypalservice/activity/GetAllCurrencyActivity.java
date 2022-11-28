package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.GetAllCurrencyRequest;
import com.nashss.se.currencypalservice.activity.results.GetAllCurrencyResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.CurrencyDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.models.CurrencyModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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

    public GetAllCurrencyResult handleRequest(final GetAllCurrencyRequest getAllCurrencyRequest) {
        log.info("Recieved GetAllCurrencyRequest {}", getAllCurrencyRequest);
        List<Currency> currencyList = currencyDAO.getAllCurrency();
        Set<CurrencyModel> currencySet = new HashSet<CurrencyModel>();
        for(Currency currency : currencyList) {
            CurrencyModel currencyModel = new ModelConverter().toCurrencyModel(currency);
            currencySet.add(currencyModel);
        }
        return GetAllCurrencyResult.builder()
                .withCurrencies(currencySet)
                .build();
    }
}
