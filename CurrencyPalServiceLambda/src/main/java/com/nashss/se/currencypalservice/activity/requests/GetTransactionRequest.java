package com.nashss.se.currencypalservice.activity.requests;

public class GetTransactionRequest {
    private final String transactionId;

    private GetTransactionRequest(String transactionId) {
        this.transactionId = transactionId;
    }
    public String getTransactionId() {
        return transactionId;
    }
    /**
     * Convert the GetTransactionRequest to a string.
     * @return returns the GetTransactionRequest as a string
     */
    @Override
    public String toString() {
        return "GetTransactionRequest{" +
                "transactionId='" + transactionId + '\'' +
                '}';
    }
    //CHECKSTYLE:OFF:Builder
    public static Builder builder(){
        return new Builder();
    }

    public static class Builder {
        private String transactionId;

        public Builder withTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public GetTransactionRequest build() {
            return new GetTransactionRequest(transactionId);
        }
    }
}
