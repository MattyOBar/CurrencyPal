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
    private double currentRate;
    private String currencyType;
    private int ranking;

    /**
     * This constructs a Currency object.
     * @param currentRate The current rate used for currency conversion.
     * @param currencyType The enum containing the currencyAbrv, currencyName, and currencySymbol
     * @param ranking the ranking of popularity of the use of the currency
     */
    public Currency(double currentRate, String currencyType, int ranking) {
        this.currentRate = currentRate;
        this.currencyType = currencyType;
        this.ranking = ranking;
    }

    @DynamoDBAttribute(attributeName = "currentRate")
    public double getCurrentRate() {
        return currentRate;
    }

    @DynamoDBHashKey(attributeName = "currencyType")
    public String getCurrencyType() {
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
        return Objects.hash(currencyType,currentRate, ranking);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currentRate='" + currentRate + '\'' +
                ", currencyType='" + currencyType + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }
}
