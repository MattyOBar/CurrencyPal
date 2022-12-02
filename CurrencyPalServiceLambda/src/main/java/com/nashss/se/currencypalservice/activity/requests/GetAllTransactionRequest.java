package com.nashss.se.currencypalservice.activity.requests;

public class GetAllTransactionRequest {
    /**
     * Convert the GetAllTransactionRequest to a string.
     * @return returns the GetAllTransactionRequest as a string
     */
    @Override
    public String toString() {
        return super.toString();
    }

    //CHECKSTYLE:OFF:Builder
    public static GetAllTransactionRequest.Builder builder(){
        return new GetAllTransactionRequest.Builder();
    }
    //CHECKSTYLE:OFF:Builder
    public static class Builder {

        public GetAllTransactionRequest build() {
            return new GetAllTransactionRequest();
        }
    }
}
