package com.nashss.se.currencypalservice.activity.requests;

import com.nashss.se.currencypalservice.dynamodb.models.CurrencyType;

public class GetCurrencyRequest {
    private final String currencyType;

    private GetCurrencyRequest(String currencyType) {
        this.currencyType = currencyType;
    }
    public String getCurrencyType() {
        return currencyType;
    }

    /**
     * Convert the GetCurrencyRequest to a string.
     * @return returns the GetCurrencyRequest as a string
     */
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
        private String currencyType;

        public Builder withCurrencyType(String currencyType) {
            this.currencyType = currencyType;
            return this;
        }

        public GetCurrencyRequest build() {
            return new GetCurrencyRequest(currencyType);
        }
    }



}
