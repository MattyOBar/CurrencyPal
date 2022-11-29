package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.CurrencyModel;

import java.util.Set;

public class GetAllCurrencyResult {
    private final Set<CurrencyModel> currencyModelSet;

    private GetAllCurrencyResult(Set<CurrencyModel> currencyModelSet) {
        this.currencyModelSet = currencyModelSet;
    }

    public Set<CurrencyModel> getCurrencyModelSet() {
        return currencyModelSet;
    }

    @Override
    public String toString() {
        return "GetAllCurrencyResult{" +
                "currencyModelSet=" + currencyModelSet +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Set<CurrencyModel> currencyModelSet;

        public Builder withCurrencies(Set<CurrencyModel> currencyModelSet) {
            this.currencyModelSet = currencyModelSet;
            return this;
        }

        public GetAllCurrencyResult build() {
            return new GetAllCurrencyResult(currencyModelSet);
        }
    }
}
