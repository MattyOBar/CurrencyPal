package com.nashss.se.currencypalservice.models;

import com.nashss.se.currencypalservice.dynamodb.models.CurrencyType;

import java.util.Objects;

public class CurrencyModel {
    private final double currentRate;
    private final CurrencyType currencyType;
    private final int ranking;

    private CurrencyModel(double currentRate, CurrencyType currencyType, int ranking) {
        this.currentRate = currentRate;
        this.currencyType = currencyType;
        this.ranking = ranking;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
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
        return currencyType.equals(that.currencyType) &&
                Objects.equals(currentRate, that.currentRate) &&
                Objects.equals(ranking, that.ranking);
    }
    @Override
    public int hashCode() {
        return Objects.hash(currentRate, currencyType, ranking);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private double currentRate;

        private CurrencyType currencyType;
        private int ranking;

        public Builder withCurrentRate(double currentRate) {
            this.currentRate = currentRate;
            return this;
        }

        public Builder withCurrencyType(CurrencyType currencyType) {
            this.currencyType = currencyType;
            return this;
        }

        public Builder withRating (int ranking) {
            this.ranking = ranking;
            return this;
        }

        public CurrencyModel build() {
            return new CurrencyModel(currentRate,currencyType, ranking);
        }
    }
}
