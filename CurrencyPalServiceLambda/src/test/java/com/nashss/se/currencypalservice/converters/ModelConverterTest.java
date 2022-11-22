package com.nashss.se.currencypalservice.converters;

import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.models.CurrencyModel;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ModelConverterTest {
    private ModelConverter modelConverter = new ModelConverter();

    @Test
    void toCurrencyModel_convertsCurrency() {
        //GIVEN
        Currency currency = new Currency(1, "USD", 1);

        //WHEN
        CurrencyModel currencyModel = modelConverter.toCurrencyModel(currency);

        //THEN
        assertEquals(currency.getCurrentRate(), currencyModel.getCurrentRate());
        assertEquals(currency.getCurrencyAbrv(), currencyModel.getCurrencyAbrv());
        assertEquals(currency.getRanking(), currencyModel.getRanking());
    }
}
