package com.nashss.se.currencypalservice.models;

import java.util.Objects;

public class CurrencyModel {
    private final double currentRate;
    private final String currencyAbrv;
    private final int ranking;

    private CurrencyModel(double currentRate, String currencyAbrv, int ranking) {
        this.currentRate = currentRate;
        this.currencyAbrv = currencyAbrv;
        this.ranking = ranking;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public String getCurrencyAbrv() {
        return currencyAbrv;
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
                Objects.equals(ranking, that.ranking);
    }
    @Override
    public int hashCode() {
        return Objects.hash(currentRate, currencyAbrv, ranking);
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private double currentRate;

        private String currencyAbrv;
        private int ranking;

        public Builder withCurrentRate(double currentRate) {
            this.currentRate = currentRate;
            return this;
        }

        public Builder withCurrencyAbrv(String currencyAbrv) {
            this.currencyAbrv = currencyAbrv;
            return this;
        }

        public Builder withRating (int ranking) {
            this.ranking = ranking;
            return this;
        }

        public CurrencyModel build() {
            return new CurrencyModel(currentRate, currencyAbrv, ranking);
        }
    }
}
