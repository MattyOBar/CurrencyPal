package com.nashss.se.currencypalservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

/**
 * Represents a Currency in the Currency table.
 */
@DynamoDBTable(tableName = "Currencies")
public class Currency {
    private String currencyAbrv;

    private String currencyName;
    private double currentRate;
    private int ranking;

    @DynamoDBHashKey(attributeName = "currencyAbrv")
    public String getCurrencyAbrv() {
        return currencyAbrv;
    }

    public void setCurrencyAbrv(String currencyAbrv) {
        this.currencyAbrv = currencyAbrv;
    }

    @DynamoDBAttribute(attributeName = "currencyName")
    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @DynamoDBAttribute(attributeName = "currentRate")
    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    @DynamoDBAttribute(attributeName = "ranking")
    public int getRanking() {
        return ranking;
    }

    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Currency that = (Currency) o;
        return currencyAbrv.equals(that.currencyAbrv) &&
                Objects.equals(currencyName, that.currencyName) &&
                Objects.equals(currentRate, that.currentRate) &&
                Objects.equals(ranking, that.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyAbrv, currencyName, currentRate, ranking);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyAbrv='" + currencyAbrv + '\'' +
                ", currencyName='" + currencyName + '\'' +
                ", currentRate='" + currentRate + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }
}
