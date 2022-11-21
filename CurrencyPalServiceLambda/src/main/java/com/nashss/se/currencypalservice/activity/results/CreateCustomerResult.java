package com.nashss.se.currencypalservice.activity.results;

import com.nashss.se.currencypalservice.models.CustomerModel;

public class CreateCustomerResult {
    private final CustomerModel customer;

    private CreateCustomerResult(CustomerModel customer) {
        this.customer = customer;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    /**
     * toString method.
     * @return customer.
     */
    public String toString() {
        return "CreateCustomerResult" +
                "customer: " + customer;
    }
    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private CustomerModel customer;

        public Builder withPlaylist(CustomerModel customer) {
            this.customer = customer;
            return this;
        }

        public CreateCustomerResult build() {
            return new CreateCustomerResult(customer);
        }
    }
}
