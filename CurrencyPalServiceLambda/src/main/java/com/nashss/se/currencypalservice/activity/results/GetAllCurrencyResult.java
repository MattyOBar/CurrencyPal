package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.CurrencyModel;

import java.util.List;

public class GetAllCurrencyResult {
    private final List<CurrencyModel> currencyModelList;

    private GetAllCurrencyResult(List<CurrencyModel> currencyModelList) {
        this.currencyModelList = currencyModelList;
    }

    public List<CurrencyModel> getCurrencyModelSet() {
        return currencyModelList;
    }


    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private List<CurrencyModel> currencyModelList;

        public Builder withCurrencies(List<CurrencyModel> currencyModelList) {
            this.currencyModelList = currencyModelList;
            return this;
        }

        public GetAllCurrencyResult build() {
            return new GetAllCurrencyResult(currencyModelList);
        }
    }
}
