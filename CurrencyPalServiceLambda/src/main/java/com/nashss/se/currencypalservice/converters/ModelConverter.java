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
                .withCurrentRate(currency.getCurrentRate())
                .withRating(currency.getRanking())
                .build();
    }
    /**
     * Converts a provided {@link Customer} into a {@link CustomerModel} representation.
     * @param newCustomer the customer to convert
     * @return the converted playlist
     */
    public CustomerModel toCustomerModel(Customer newCustomer) {
        return CustomerModel.builder()
                .withCustomerId(newCustomer.getCustomerId())
                .withName(newCustomer.getName())
                .withDateOfBirth(newCustomer.getDateOfBirth())
                .build();
    }
}
