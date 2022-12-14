package com.nashss.se.currencypalservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

@DynamoDBTable(tableName = "Transactions")
public class Transaction {

    private String transactionId;
    private String customerName;
    private String startCurrency;
    private String endCurrency;
    private double startAmount;
    private double endAmount;

    @DynamoDBHashKey(attributeName = "transactionId")
    public String getTransactionId() {
        return transactionId;
    }

    @DynamoDBAttribute(attributeName = "customerName")
    public String getCustomerName() {
        return customerName;
    }


    @DynamoDBAttribute(attributeName = "startCurrency")
    public String  getStartCurrency() {
        return startCurrency;
    }

    @DynamoDBAttribute(attributeName = "endCurrency")
    public String getEndCurrency() {
        return endCurrency;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setStartCurrency(String startCurrency) {
        this.startCurrency = startCurrency;
    }

    public void setEndCurrency(String endCurrency) {
        this.endCurrency = endCurrency;
    }

    public void setStartAmount(double startAmount) {
        this.startAmount = startAmount;
    }

    public void setEndAmount(double endAmount) {
        this.endAmount = endAmount;
    }

    @DynamoDBAttribute(attributeName = "startAmount")
    public double getStartAmount() {
        return startAmount;
    }

    @DynamoDBAttribute(attributeName = "endAmount")
    public double getEndAmount() {
        return endAmount;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", startCurrency='" + startCurrency + '\'' +
                ", endCurrency='" + endCurrency + '\'' +
                ", startAmount=" + startAmount +
                ", endAmount=" + endAmount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Transaction that = (Transaction) o;
        return Double.compare(that.startAmount, startAmount) == 0 && Double.compare(that.endAmount, endAmount) == 0 &&
                transactionId.equals(that.transactionId) && Objects.equals(customerName, that.customerName) &&
                Objects.equals(startCurrency, that.startCurrency) && Objects.equals(endCurrency, that.endCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactionId, customerName, startCurrency, endCurrency, startAmount, endAmount);
    }
}
