package com.nashss.se.currencypalservice.activity.requests;

public class GetCurrencyRequest {
    private final String currencyAbrv;

    private GetCurrencyRequest(String currencyAbrv) {
        this.currencyAbrv = currencyAbrv;
    }
    public String getCurrencyAbrv() {
        return currencyAbrv;
    }

    /**
     * Convert the GetCurrencyRequest to a string.
     * @return returns the GetCurrencyRequest as a string
     */
    @Override
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
        private String currencyAbrv;

        public Builder withCurrencyAbrv(String currencyAbrv) {
            this.currencyAbrv = currencyAbrv;
            return this;
        }

        public GetCurrencyRequest build() {
            return new GetCurrencyRequest(currencyAbrv);
        }
    }



}
