package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.GetCurrencyRequest;
import com.nashss.se.currencypalservice.activity.results.GetCurrencyResult;
import com.nashss.se.currencypalservice.dynamodb.DAO.CurrencyDAO;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyAbrv;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


public class GetCurrencyActivity {

    private final Logger log = LogManager.getLogger();
    private final CurrencyDAO currencyDAO;

    @Inject
    public GetCurrencyActivity(CurrencyDAO currencyDAO) {
        this.currencyDAO = currencyDAO;
    }

    public GetCurrencyResult handleRequest(final GetCurrencyRequest getCurrencyRequest) {
        log.info("Received GetCurrencyRequest {}", getCurrencyRequest);
        CurrencyAbrv requestedCurrencyAbrv = getCurrencyRequest.g



    }




}
