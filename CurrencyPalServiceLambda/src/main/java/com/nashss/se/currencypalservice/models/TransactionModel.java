package com.nashss.se.currencypalservice.models;

import com.amazonaws.internal.config.Builder;

import java.util.Objects;

public class TransactionModel {
    private final String transactionId;
    private final String customerName;
    private final String startCurrency;
    private final String endCurrency;
    private final double startAmount;
    private final double endAmount;
    public TransactionModel(String transactionId, String customerName, String startCurrency, String endCurrency, double startAmount, double endAmount) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionModel that = (TransactionModel) o;
        return Double.compare(that.startAmount, startAmount) == 0 && Double.compare(that.endAmount, endAmount) == 0 && transactionId.equals(that.transactionId) && Objects.equals(customerName, that.customerName) && Objects.equals(startCurrency, that.startCurrency) && Objects.equals(endCurrency, that.endCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, customerName, startCurrency, endCurrency, startAmount, endAmount);
    }
    //CHECKSTYLE:OFF:Builder
    public static CurrencyModel.Builder builder() {
        return new CurrencyModel.Builder();
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
        public TransactionModel build() {
            return new TransactionModel(transactionId, customerName, startCurrency, endCurrency, startAmount, endAmount);
        }
    }
}
