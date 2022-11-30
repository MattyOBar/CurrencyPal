package com.nashss.se.currencypalservice.activity.requests;

import org.apache.commons.lang3.builder.Builder;

public class CreateTransactionRequest {
    private final String transactionId;
    private final String customerName;
    private final String startCurrency;
    private final String endCurrency;
    private final double startAmount;
    private final double endAmount;

    private CreateTransactionRequest(String transactionId, String customerName,
                                     String startCurrency, String endCurrency, double startAmount, double endAmount) {
        this.transactionId = transactionId;
        this.customerName = customerName;
        this.startCurrency = startCurrency;
        this.endCurrency = endCurrency;
        this.startAmount = startAmount;
        this.endAmount = endAmount;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getStartCurrency() {
        return startCurrency;
    }

    public String getEndCurrency() {
        return endCurrency;
    }

    public double getStartAmount() {
        return startAmount;
    }

    public double getEndAmount() {
        return endAmount;
    }

    @Override
    public String toString() {
        return "CreateTransactionRequest{" +
                "transactionId='" + transactionId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", startCurrency='" + startCurrency + '\'' +
                ", endCurrency='" + endCurrency + '\'' +
                ", startAmount=" + startAmount +
                ", endAmount=" + endAmount +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String transactionId;
        private String customerName;
        private String startCurrency;
        private String endCurrency;
        private double startAmount;
        private double endAmount;

        public Builder withTransactionId(String transactionId) {
            this.transactionId = transactionId;
            return this;
        }

        public Builder withCustomerName(String customerName) {
            this.customerName = customerName;
            return this;
        }

        public Builder withStartCurrency(String startCurrency) {
            this.startCurrency = startCurrency;
            return this;
        }

        public Builder withEndCurrency(String endCurrency) {
            this.endCurrency = endCurrency;
            return this;
        }

        public Builder withStartAmount(double startAmount) {
            this.startAmount = startAmount;
            return this;
        }

        public Builder withEndAmount(double endAmount) {
            this.endAmount = endAmount;
            return this;
        }

        public CreateTransactionRequest build() {
            return new CreateTransactionRequest(transactionId, customerName, startCurrency, endCurrency, startAmount, endAmount);
        }
    }
}
