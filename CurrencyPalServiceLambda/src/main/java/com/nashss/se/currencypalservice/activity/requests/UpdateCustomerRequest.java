package com.nashss.se.currencypalservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = UpdateCustomerRequest.Builder.class)
public class UpdateCustomerRequest {
    private final String customerId;
    private final String name;
    private final String dateOfBirth;

    private UpdateCustomerRequest(String customerId, String name, String dateOfBirth) {
        this.customerId = customerId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public String toString() {
        return "UpdateCustomerRequest{" +
                "CustomerId:'" + customerId + '\'' +
                ", Name:'" + name + '\'' +
                ", Date of birth:'" + dateOfBirth + '\'' +
                '}';
    }

    //CHECKSTYLE:OFF:Builder
    public static Builder builder() {
        return new Builder();
    }
    @JsonPOJOBuilder
    public static class Builder {
        private String customerId;
        private String name;
        private String dateOfBirth;

        public Builder withCustomerId(String customerId) {
            this.customerId = customerId;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
            return this;
        }

        public UpdateCustomerRequest build() {
            return new UpdateCustomerRequest(customerId, name, dateOfBirth);
        }
    }
}
