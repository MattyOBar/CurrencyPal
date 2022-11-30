package com.nashss.se.currencypalservice.activity.requests;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

import java.awt.*;

@JsonDeserialize(builder = CreateCustomerRequest.Builder.class)
public class CreateCustomerRequest {
    private final String customerId;
    private final String name;
    private final String dateOfBirth;

    private  final List<String> tags;

    /**
     * This constructs a Customer object.
     * @param customerId A unique ID given to a customer.
     * @param name Customer name attached to the customerId
     * @param dateOfBirth Date of birth of the customer
     */
    public CreateCustomerRequest(String customerId, String name, String dateOfBirth) {
        this.customerId = customerId;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.tags = tags;
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

    /**
     * toString method that converts a class to a string.
     * @return customerId , name, and date of birth
     */
    @Override
    public String toString() {
        return "CreateCustomerRequest{" +
                "customerId =" + customerId +
                "name =" +  name +
                "dateOfBirth =" + dateOfBirth;
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
    }
}
