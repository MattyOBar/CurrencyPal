package com.nashss.se.currencypalservice.activity.requests;

public class GetCustomerRequest {
    private final String customerId;

    /**
     * This constructs a customer object.
     * @param customerId A unique ID given to a customer.
     */
    public GetCustomerRequest(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerId() {
        return customerId;
    }

    /**
     * toString method that converts a class to a string.
     * @return customerId.
     */
    public String toString() {
        return "GetCustomerRequest:" +
                "customerId=" + customerId;
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String customerId;

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public GetCustomerRequest build() {
            return new GetCustomerRequest(customerId);
        }
    }
}
