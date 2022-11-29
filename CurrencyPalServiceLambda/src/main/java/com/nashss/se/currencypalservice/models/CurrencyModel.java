package com.nashss.se.currencypalservice.models;

import java.util.Objects;

public class CurrencyModel {
    private final String currencyAbrv;
    private final String currencyName;
    private final double currentRate;
    private final int ranking;

    private CurrencyModel(String currencyAbrv, String currencyName, double currentRate, int ranking) {
        this.currencyAbrv = currencyAbrv;
        this.currencyName = currencyName;
        this.currentRate = currentRate;
        this.ranking = ranking;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public String getCurrencyAbrv() {
        return currencyAbrv;
    }

    public String getCurrencyName() {
        return currencyName;
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
                Objects.equals(currencyName, that.currencyName) &&
                Objects.equals(currentRate, that.currentRate) &&
                Objects.equals(ranking, that.ranking);
    }
    @Override
    public int hashCode() {
        return Objects.hash(currentRate, currencyName, currencyAbrv, ranking);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private double currentRate;

        private String currencyAbrv;
        private String currencyName;
        private int ranking;

        public Builder withCurrentRate(double currentRate) {
            this.currentRate = currentRate;
            return this;
        }

        public Builder withCurrencyAbrv(String currencyAbrv) {
            this.currencyAbrv = currencyAbrv;
            return this;
        }

        public Builder withCurrencyName(String currencyName) {
            this.currencyName = currencyName;
            return this;
        }

        public Builder withRating (int ranking) {
            this.ranking = ranking;
            return this;
        }

        public CurrencyModel build() {
            return new CurrencyModel(currencyAbrv, currencyName, currentRate, ranking);
        }
    }
}
