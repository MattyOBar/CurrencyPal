package com.nashss.se.currencypalservice.activity.requests;

public class GetAllCurrencyRequest {
    private GetAllCurrencyRequest() {
    }
    /**
     * Convert the GetCurrencyRequest to a string.
     * @return returns the GetAllCurrencyRequest as a string
     */
    @Override
    public String toString() {
        return super.toString();
    }

    //CHECKSTYLE:OFF:Builder
    public static class Builder {

        public GetAllCurrencyRequest build() {
            return new GetAllCurrencyRequest();
        }
    }
}
