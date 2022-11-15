package com.nashss.se.currencypalservice.dynamodb.DAO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyType;
import com.nashss.se.currencypalservice.exceptions.CurrencyNotFoundException;
import com.nashss.se.currencypalservice.metrics.MetricsConstants;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static com.nashss.se.currencypalservice.dynamodb.models.CurrencyType.US_DOLLAR;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class CurrencyDAOTest {
    @Mock
    private DynamoDBMapper dynamoDBMapper;
    @Mock
    private MetricsPublisher metricsPublisher;

    private CurrencyDAO currencyDAO;

    Currency testCurrency = new Currency(1, US_DOLLAR, 1);
    @BeforeEach
    public void setup() {
        openMocks(this);
        currencyDAO = new CurrencyDAO(dynamoDBMapper, metricsPublisher);
    }

    @Test
    public void getCurrency_withCurrencyAbrv_callsMapperWithParitionKey() {
        //GIVEN
        when(dynamoDBMapper.load(Currency.class, US_DOLLAR)).thenReturn(testCurrency);

        //WHEN
        Currency currency = currencyDAO.getCurrency(US_DOLLAR);

        //THEN
        assertNotNull(currency);
        verify(dynamoDBMapper).load(Currency.class, US_DOLLAR);
        verify(metricsPublisher).addCount(eq(MetricsConstants.GETCURRENCY_CURRENCYNOTFOUND_COUNT), anyDouble());
    }

    @Test
    public void getCurrency_currencyAbrvNotFound_ThrowsCurrencyNotFoundException() {
        //GIVEN
        CurrencyType nonexistantCurrencyAbrv = null;
        when(dynamoDBMapper.load(Currency.class, nonexistantCurrencyAbrv)).thenReturn(null);

        //WHEN + THEN
        assertThrows(CurrencyNotFoundException.class, () -> currencyDAO.getCurrency(nonexistantCurrencyAbrv));
        verify(metricsPublisher).addCount(eq(MetricsConstants.GETCURRENCY_CURRENCYNOTFOUND_COUNT), anyDouble());
    }

    @Test
    public void updateCurrency_currencyRateIsUpdated_returnsTrue() {
        //GIVEN
        when(dynamoDBMapper.load(Currency.class, US_DOLLAR)).thenReturn(testCurrency);

        //WHEN
        testCurrency = currencyDAO.updateCurrency(US_DOLLAR, 5.0);

        //THEN
        assertEquals(5.0, testCurrency.getCurrentRate());
        verify(dynamoDBMapper).save(testCurrency);
        verify(metricsPublisher).addCount(eq(MetricsConstants.UPDATECURRENCY_CURRENCYNOTFOUND_COUNT), anyDouble());

    }
}