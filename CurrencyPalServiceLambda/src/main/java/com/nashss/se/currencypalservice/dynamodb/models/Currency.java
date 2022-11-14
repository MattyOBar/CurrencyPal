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
    CurrencyNames countryName;

    CurrencySymbol currencySymbol;
    int ranking;

    @DynamoDBAttribute(attributeName = "currentRate")
    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    @DynamoDBHashKey(attributeName = "currencyAbrv")
    public CurrencyAbrv getCurrencyAbrv() {
        return currencyAbrv;
    }

    public void setCurrencyAbrv(CurrencyAbrv currencyAbrv) {
        this.currencyAbrv = currencyAbrv;
    }

    @DynamoDBAttribute(attributeName = "countryName")
    public CurrencyNames getCountryName() {
        return countryName;
    }

    public void setCountryName(CurrencyNames countryName) {
        this.countryName = countryName;
    }

    @DynamoDBAttribute(attributeName = "countrySymbol")
    public CurrencySymbol getCurrencySymbol() {
        return currencySymbol;
    }

    public void setCurrencySymbol(CurrencySymbol currencySymbol) {
        this.currencySymbol = currencySymbol;
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
                Objects.equals(currentRate, that.currentRate) &&
                Objects.equals(countryName, that.countryName) &&
                Objects.equals(currencySymbol, that.currencySymbol) &&
                Objects.equals(ranking, that.ranking);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentRate, currencyAbrv, countryName, currencySymbol, ranking);
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currentRate='" + currentRate + '\'' +
                ", currencyAbrv=" + currencyAbrv +
                ", countryName='" + countryName + '\'' +
                ", currencySymbol='" + currencySymbol + '\'' +
                ", ranking='" + ranking + '\'' +
                '}';
    }
}
