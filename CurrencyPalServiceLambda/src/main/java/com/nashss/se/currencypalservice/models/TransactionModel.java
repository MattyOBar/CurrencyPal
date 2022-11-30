package com.nashss.se.currencypalservice.models;

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
}
