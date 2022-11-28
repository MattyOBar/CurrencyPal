package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.CustomerModel;

public class UpdateCustomerResult {
    private final CustomerModel customer;

    private UpdateCustomerResult(CustomerModel customer) {
        this.customer = customer;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return "UpdateCustomerResult" +
                "customer: " + customer;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CustomerModel customer;

        public Builder withCustomer(CustomerModel customer) {
            this.customer = customer;
            return this;
        }

        public UpdateCustomerResult build() {
            return new UpdateCustomerResult(customer);
        }
    }
}
