package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.GetCurrencyRequest;
import com.nashss.se.currencypalservice.activity.results.GetCurrencyResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.CurrencyDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyType;
import com.nashss.se.currencypalservice.models.CurrencyModel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;

/**
 * Implementation of the GetCurrencyActivity for the CurrencyPal GetCurrencyAPI.
 *
 * This API allows the operator to get a specific currency.
 */

public class GetCurrencyActivity {

    private final Logger log = LogManager.getLogger();
    private final CurrencyDAO currencyDAO;
    /**
     * Instantiates a new GetCurrencyActivity Object.
     *
     * @param currencyDAO CurrencyDAO to access the currency table.
     */
    @Inject
    public GetCurrencyActivity(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    /**
     * This method handles the incoming request by retrieving the playlist from the data base.
     * @param getCurrencyRequest the request object containing the CurrencyType.
     * @return getCurrencyResult the result object containing the API defined {@link CurrencyModel}.
     */
    public GetCurrencyResult handleRequest(final GetCurrencyRequest getCurrencyRequest) {
        log.info("Received GetCurrencyRequest {}", getCurrencyRequest);
        CurrencyType currencyType = getCurrencyRequest.getCurrencyType();
        Currency currency = currencyDAO.getCurrency(currencyType);
        CurrencyModel currencyModel = new ModelConverter().toCurrencyModel(currency);
        return GetCurrencyResult.builder()
                .withCurrency(currencyModel)
                .build();
    }
}
