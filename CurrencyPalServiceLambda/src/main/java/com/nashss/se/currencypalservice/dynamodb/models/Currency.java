package com.nashss.se.currencypalservice.dynamodb.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import java.util.Objects;

/**
 * Represents a Currency in the Currency table.
 */
@DynamoDBTable(tableName = "Currency")
public class Currency {
    private double currentRate;
    CurrencyType currencyType;
    int ranking;

    public Currency(double currentRate, CurrencyType currencyType, int ranking) {
        this.currentRate = currentRate;
        this.currencyType = currencyType;
        this.ranking = ranking;
    }

    @DynamoDBAttribute(attributeName = "currentRate")
    public double getCurrentRate() {
        return currentRate;
    }

    @DynamoDBAttribute(attributeName = "currencyType")
    public CurrencyType getCurrencyType() {
        return currencyType;
    }
    @DynamoDBAttribute(attributeName = "ranking")
    public int getRanking() {
        return ranking;
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
        return currencyType.equals(that.currencyType) &&
                Objects.equals(currentRate, that.currentRate) &&
                Objects.equals(ranking, that.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentRate, currencyType, ranking);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currentRate='" + currentRate + '\'' +
                ", countryName='" + currencyType + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }
}
