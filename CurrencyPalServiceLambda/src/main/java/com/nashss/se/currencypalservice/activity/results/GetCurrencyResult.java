package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.CurrencyModel;

public class GetCurrencyResult {
    private final CurrencyModel currencyModel;

    private GetCurrencyResult(CurrencyModel currencyModel) {
        this.currencyModel = currencyModel;
    }

    public CurrencyModel getCurrencyModel() {
        return currencyModel;
    }

    @Override
    public String toString() {
        return "GetCurrencyResult{" +
                "currencyModel=" + currencyModel +
                '}';
    }


    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CurrencyModel currencyModel;

        public Builder withCurrency(CurrencyModel currencyModel) {
            this.currencyModel = currencyModel;
            return this;
        }

        public GetCurrencyResult build() {
            return new GetCurrencyResult(currencyModel);
        }
    }




}
