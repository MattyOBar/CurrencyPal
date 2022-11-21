package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.GetCurrencyRequest;
import com.nashss.se.currencypalservice.activity.results.GetCurrencyResult;
import com.nashss.se.currencypalservice.dynamodb.DAO.CurrencyDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

class GetCurrencyActivityTest {
    @Mock
    private CurrencyDAO currencyDAO;

    private GetCurrencyActivity getCurrencyActivity;

    @BeforeEach
    public void setUP() {
        openMocks(this);
        getCurrencyActivity = new GetCurrencyActivity(currencyDAO);
    }

    @Test
    public void handleRequest_savedCurrencyReturned_ReturnsCurrencyModelInResult() {
        //GIVEN
        double expectedRate = 1;
        String expectedCurrencyType = CurrencyType.US_DOLLAR.getCurrencyAbrv();
        int expectedRanking = 1;

        Currency currency = new Currency(expectedRate, expectedCurrencyType, expectedRanking);

        when(currencyDAO.getCurrency(expectedCurrencyType)).thenReturn(currency);

        GetCurrencyRequest request = GetCurrencyRequest.builder()
                .withCurrencyType(expectedCurrencyType)
                .build();

        //WHEN
        GetCurrencyResult result = getCurrencyActivity.handleRequest(request);

        //THEN
        assertEquals(expectedRate, result.getCurrencyModel().getCurrentRate());
        assertEquals(expectedCurrencyType, result.getCurrencyModel().getCurrencyType());
        assertEquals(expectedRanking, result.getCurrencyModel().getRanking());


    }
}