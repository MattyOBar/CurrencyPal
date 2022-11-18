package com.nashss.se.currencypalservice.converters;

import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.models.CurrencyModel;

/**
 * Converts between Data and Coral models.
 */
public class ModelConverter {

    /**
     * Converts a provided {@link Currency} into a {@link CurrencyModel} representation.
     * @param currency the currency to convert
     * @return the converted playlist
     */
    public CurrencyModel toCurrencyModel(Currency currency) {
        return CurrencyModel.builder()
                .withCurrencyType(currency.getCurrencyType())
                .withCurrentRate(currency.getCurrentRate())
                .withRating(currency.getRanking())
                .build();
    }
}
