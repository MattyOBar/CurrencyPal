package com.nashss.se.currencypalservice.activity.requests;

import com.nashss.se.currencypalservice.activity.results.GetCurrencyResult;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyAbrv;
import com.nashss.se.currencypalservice.models.CurrencyModel;
import org.apache.commons.lang3.builder.Builder;

public class GetCurrencyRequest {
    private final CurrencyAbrv currencyAbrv;

    private GetCurrencyRequest(CurrencyAbrv currencyAbrv) {
        this.currencyAbrv = currencyAbrv;
    }

    public String toString() {
        return "GetCurrencyRequest{" +
                "currencyAbrv ='" + currencyAbrv + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private CurrencyAbrv currencyAbrv;

        public Builder withCurrencyAbrv(CurrencyAbrv currencyAbrv) {
            this.currencyAbrv = currencyAbrv;
            return this;
        }

        public GetCurrencyRequest build() {
            return new GetCurrencyRequest(currencyAbrv);
        }
    }



}
