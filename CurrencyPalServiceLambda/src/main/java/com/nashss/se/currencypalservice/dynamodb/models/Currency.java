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
    CurrencyAbrv currencyAbrv;
    CurrencyName currencyName;

    CurrencySymbol currencySymbol;
    int ranking;

    public Currency(double currentRate, CurrencyAbrv currencyAbrv, CurrencyName currencyName, CurrencySymbol currencySymbol, int ranking) {
        this.currentRate = currentRate;
        this.currencyAbrv = currencyAbrv;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
        this.ranking = ranking;
    }

    @DynamoDBAttribute(attributeName = "currentRate")
    public double getCurrentRate() {
        return currentRate;
    }

    @DynamoDBHashKey(attributeName = "currencyAbrv")
    public CurrencyAbrv getCurrencyAbrv() {
        return currencyAbrv;
    }

    @DynamoDBAttribute(attributeName = "currencyName")
    public CurrencyName getCurrencyName() {
        return currencyName;
    }

    @DynamoDBAttribute(attributeName = "currencySymbol")
    public CurrencySymbol getCurrencySymbol() {
        return currencySymbol;
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
                Objects.equals(currencyName, that.currencyName) &&
                Objects.equals(currencySymbol, that.currencySymbol) &&
                Objects.equals(ranking, that.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentRate, currencyAbrv, currencyName, currencySymbol, ranking);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currentRate='" + currentRate + '\'' +
                ", currencyAbrv=" + currencyAbrv +
                ", countryName='" + currencyName + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }
}
