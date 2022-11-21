package com.nashss.se.currencypalservice.converters;

import com.google.common.collect.Sets;
import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyType;
import com.nashss.se.currencypalservice.models.CurrencyModel;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static com.nashss.se.currencypalservice.utils.CollectionUtils.copyToSet;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ModelConverterTest {
    private ModelConverter modelConverter = new ModelConverter();

    @Test
    void toCurrencyModel_convertsCurrency() {
        //GIVEN
        Currency currency = new Currency(1, CurrencyType.US_DOLLAR, 1);

        //WHEN
        CurrencyModel currencyModel = modelConverter.toCurrencyModel(currency);

        //THEN
        assertEquals(currency.getCurrentRate(), currencyModel.getCurrentRate());
        assertEquals(currency.getCurrencyType(), currencyModel.getCurrencyType());
        assertEquals(currency.getRanking(), currencyModel.getRanking());
    }
}
