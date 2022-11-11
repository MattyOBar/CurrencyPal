package com.nashss.se.currencypalservice.dynamodb.DAO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.currencypalservice.dynamodb.models.CountryName;
import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyAbrv;
import com.nashss.se.currencypalservice.exceptions.CurrencyNotFoundException;
import com.nashss.se.currencypalservice.metrics.MetricsConstants;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static com.nashss.se.currencypalservice.dynamodb.models.CountryName.UNITEDSTATESOFAMERICA;
import static com.nashss.se.currencypalservice.dynamodb.models.CurrencyAbrv.USD;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.MockitoAnnotations.openMocks;

class CurrencyDAOTest {
    @Mock
    private DynamoDBMapper dynamoDBMapper;
    @Mock
    private MetricsPublisher metricsPublisher;

    private CurrencyDAO currencyDAO;
    @BeforeEach
    public void setup() {
        openMocks(this);
        currencyDAO = new CurrencyDAO(dynamoDBMapper, metricsPublisher);
    }

    @Test
    public void getCurrency_withCurrencyAbrv_callsMapperWithParitionKey() {
        //GIVEN
        when(dynamoDBMapper.load(Currency.class, USD)).thenReturn(new Currency());

        //WHEN
        Currency currency = currencyDAO.getCurrency(USD);

        //THEN
        assertNotNull(currency);
        verify(dynamoDBMapper).load(Currency.class, USD);
        verify(metricsPublisher).addCount(eq(MetricsConstants.GETCURRENCY_CURRENCYNOTFOUND_COUNT), anyDouble());
    }

    @Test
    public void getCurrency_currencyAbrvNotFound_ThrowsCurrencyNotFoundException() {
        //GIVEN
        CurrencyAbrv nonexistantCurrencyAbrv = null;
        when(dynamoDBMapper.load(Currency.class, nonexistantCurrencyAbrv)).thenReturn(null);

        //WHEN + THEN
        assertThrows(CurrencyNotFoundException.class, () -> currencyDAO.getCurrency(nonexistantCurrencyAbrv));
        verify(metricsPublisher).addCount(eq(MetricsConstants.GETCURRENCY_CURRENCYNOTFOUND_COUNT), anyDouble());
    }

    @Test
    public void updateCurrency_currencyRateIsUpdated_returnsTrue() {
        //GIVEN
        Currency currency = new Currency();
        currency.setCurrentRate(2.5);
        currency.setCurrencyAbrv(USD);
        currency.setCountryName(UNITEDSTATESOFAMERICA);
        currency.setRanking(1);

        CurrencyAbrv currencyAbrv = USD;

        when(dynamoDBMapper.load(Currency.class, currencyAbrv)).thenReturn(currency);

        //WHEN
        currency = currencyDAO.updateCurrency(USD, 1.0);

        //THEN
        assertEquals(1.0, currency.getCurrentRate());
        verify(dynamoDBMapper).save(currency);
        verify(metricsPublisher).addCount(eq(MetricsConstants.UPDATECURRENCY_CURRENCYNOTFOUND_COUNT), anyDouble());

    }
}