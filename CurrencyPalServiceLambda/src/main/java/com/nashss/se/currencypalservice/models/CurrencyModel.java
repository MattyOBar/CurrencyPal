package com.nashss.se.currencypalservice.models;

import com.nashss.se.currencypalservice.dynamodb.models.Currency;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyAbrv;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencyNames;
import com.nashss.se.currencypalservice.dynamodb.models.CurrencySymbol;
import org.apache.commons.lang3.builder.Builder;

import java.util.Objects;

public class CurrencyModel {
    private final double currentRate;
    private final CurrencyAbrv currencyAbrv;
    private final CurrencyNames currencyNames;
    private final CurrencySymbol currencySymbol;
    private final int ranking;

    private CurrencyModel(double currentRate, CurrencyAbrv currencyAbrv, CurrencyNames currencyNames, CurrencySymbol currencySymbol, int ranking) {
        this.currentRate = currentRate;
        this.currencyAbrv = currencyAbrv;
        this.currencyNames = currencyNames;
        this.currencySymbol = currencySymbol;
        this.ranking = ranking;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public CurrencyAbrv getCurrencyAbrv() {
        return currencyAbrv;
    }

    public CurrencyNames getCurrencyNames() {
        return currencyNames;
    }

    public CurrencySymbol getCurrencySymbol() {
        return currencySymbol;
    }

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
        CurrencyModel that = (CurrencyModel) o;
        return currencyAbrv.equals(that.currencyAbrv) &&
                Objects.equals(currentRate, that.currentRate) &&
                Objects.equals(currencyNames, that.currencyNames) &&
                Objects.equals(currencySymbol, that.currencySymbol) &&
                Objects.equals(ranking, that.ranking);
    }
    @Override
    public int hashCode() {
        return Objects.hash(currentRate, currencyAbrv, currencyNames, currencySymbol, ranking);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private double currentRate;
        private CurrencyAbrv currencyAbrv;
        private CurrencyNames currencyNames;
        private CurrencySymbol currencySymbol;
        private int ranking;

        public Builder withCurrentRate(double currentRate) {
            this.currentRate = currentRate;
            return this;
        }

        public Builder withCurrencyAbrv (CurrencyAbrv currencyAbrv) {
            this.currencyAbrv = currencyAbrv;
            return this;
        }

        public Builder withCurrencyNames (CurrencyNames currencyNames) {
            this.currencyNames = currencyNames;
            return this;
        }

        public Builder withCurrencySymbol(CurrencySymbol currencySymbol) {
            this.currencySymbol = currencySymbol;
            return this;
        }

        public Builder withRating (int ranking) {
            this.ranking = ranking;
            return this;
        }

        public CurrencyModel build() {
            return new CurrencyModel(currentRate, currencyAbrv, currencyNames, currencySymbol, ranking);
        }
    }
}