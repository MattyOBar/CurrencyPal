package com.nashss.se.currencypalservice.activity.requests;

import com.nashss.se.currencypalservice.dynamodb.models.CurrencyType;

public class GetCurrencyRequest {
    private final CurrencyType currencyType;

    private GetCurrencyRequest(CurrencyType currencyType) {
        this.currencyType = currencyType;
    }
    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public String toString() {
        return "GetCurrencyRequest{" +
                "currencyType ='" + currencyType + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private CurrencyType currencyType;

        public Builder withCurrencyType(CurrencyType currencyType) {
            this.currencyType = currencyType;
            return this;
        }

        public GetCurrencyRequest build() {
            return new GetCurrencyRequest(currencyType);
        }
    }



}
