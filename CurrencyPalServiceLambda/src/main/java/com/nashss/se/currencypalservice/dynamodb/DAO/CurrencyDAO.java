package com.nashss.se.currencypalservice.dynamodb.DAO;

import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.exceptions.CurrencyNotFoundException;
import com.nashss.se.currencypalservice.metrics.MetricsConstants;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;


import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Accesses data for our currency objects.
 */

@Singleton
public class CurrencyDAO {
    private final DynamoDBMapper dynamoDBMapper;
    private final MetricsPublisher metricsPublisher;

    /**
     * Instantiates a CurrencyDao object.
     * @param dynamoDBMapper the link used to interact with the Currency table
     * @param metricsPublisher the link used to record metrics
     */
    @Inject
    public CurrencyDAO(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    /**
     * Makes a DynamoDB call to retrieve the specificied Currency.
     * @param currencyAbrv the parameter that indicates the specified Currency
     * @return the currency Object retrieved from DynamoDB
     */
    public Currency getCurrency(String currencyAbrv) {
        Currency currency = this.dynamoDBMapper.load(Currency.class, currencyAbrv);
        if (currency == null) {
            metricsPublisher.addCount(MetricsConstants.GETCURRENCY_CURRENCYNOTFOUND_COUNT, 1);
            throw new CurrencyNotFoundException("Could not find the currency: " + currencyAbrv);
        }
        metricsPublisher.addCount(MetricsConstants.GETCURRENCY_CURRENCYNOTFOUND_COUNT, 0);
        return currency;
    }

    /**
     * Makes a DynamoDB call to retrieve and update a specified Currency.
     * @param currency the parameter used to specify the Currency to be updated
     * @param currentRate the parameter used to specify the currentRate to be updated in the Currency object
     * @return the new updated currency object
     */
    public Currency updateCurrency(Currency currency, double currentRate) {
        currency.setCurrentRate(currentRate);
        this.dynamoDBMapper.save(currency);
        return currency;

    }

}

