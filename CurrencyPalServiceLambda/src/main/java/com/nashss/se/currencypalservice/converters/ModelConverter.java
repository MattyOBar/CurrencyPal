package com.nashss.se.currencypalservice.converters;

import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.Transaction;
import com.nashss.se.currencypalservice.models.CurrencyModel;
import com.nashss.se.currencypalservice.models.TransactionModel;

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

    /**
     * Converts a provided {@link Transaction} into a {@link TransactionModel} representation.
     * @param transaction the transaction to convert
     * @return the converted TransactionModel
     */
    public TransactionModel  toTransactionModel(Transaction transaction) {
        return TransactionModel.builder()
                .withTransactionId(transaction.getTransactionId())
                .withCustomerName(transaction.getCustomerName())
                .withStartCurrency(transaction.getStartCurrency())
                .withEndCurrency(transaction.getEndCurrency())
                .withStartAmount(transaction.getStartAmount())
                .withEndAmount(transaction.getEndAmount())
                .build();
    }
}
