package com.nashss.se.currencypalservice.converters;

import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.Customer;
import com.nashss.se.currencypalservice.models.CurrencyModel;
import com.nashss.se.currencypalservice.models.CustomerModel;

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
                .withCurrencyAbrv(currency.getCurrencyAbrv())
                .withCurrencyName(currency.getCurrencyName())
                .withCurrentRate(currency.getCurrentRate())
                .withRating(currency.getRanking())
                .build();
    }

    public CustomerModel toCustomerModel(Customer newCustomer) {
        return CustomerModel.builder()
                .withCustomerId(newCustomer.getCustomerId())
                .withName(newCustomer.getName())
                .withDateOfBirth(newCustomer.getDateOfBirth())
                .build();
    }
}
