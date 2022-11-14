package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.CurrencyModel;
import org.apache.commons.lang3.builder.Builder;

public class GetCurrencyResult {
    private final CurrencyModel currency;

    private GetCurrencyResult(CurrencyModel currency) {
        this.currency = currency;
    }

    public CurrencyModel getCurrency() {
        return currency;
    }

    @Override
    public String toString() {
        return "GetCurrencyResult{" +
                "currency=" + currency +
                '}';
    }


    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CurrencyModel currency;

        public Builder withCurrency(CurrencyModel currency) {
            this.currency = currency;
            return this;
        }

        public GetCurrencyResult build() {
            return new GetCurrencyResult(currency);
        }
    }




}
