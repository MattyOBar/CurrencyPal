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
    private String currencyAbrv;
    private int ranking;

    /**
     * This constructs a Currency object.
     * @param currentRate The current rate used for currency conversion.
     * @param currencyAbrv The enum containing the currencyAbrv, currencyName, and currencySymbol
     * @param ranking the ranking of popularity of the use of the currency
     */
    public Currency(double currentRate, String currencyAbrv, int ranking) {
        this.currentRate = currentRate;
        this.currencyAbrv = currencyAbrv;
        this.ranking = ranking;
    }

    @DynamoDBAttribute(attributeName = "currentRate")
    public double getCurrentRate() {
        return currentRate;
    }

    @DynamoDBHashKey(attributeName = "currencyAbrv")
    public String getCurrencyAbrv() {
        return currencyAbrv;
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
        return currencyAbrv.equals(that.currencyAbrv) &&
                Objects.equals(currentRate, that.currentRate) &&
                Objects.equals(ranking, that.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currencyAbrv,currentRate, ranking);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currentRate='" + currentRate + '\'' +
                ", currencyAbrv='" + currencyAbrv + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }
}
