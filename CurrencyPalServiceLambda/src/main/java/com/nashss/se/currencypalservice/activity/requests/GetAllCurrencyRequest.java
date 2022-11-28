package com.nashss.se.currencypalservice.activity.requests;

public class GetAllCurrencyRequest {
    private GetAllCurrencyRequest() {
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public static class Builder {

        public GetAllCurrencyRequest build() {
            return new GetAllCurrencyRequest();
        }
    }
}
