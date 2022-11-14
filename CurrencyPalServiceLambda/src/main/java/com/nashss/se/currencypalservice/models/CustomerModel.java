package com.nashss.se.currencypalservice.models;

import com.amazonaws.internal.config.Builder;

import java.util.Objects;

public class CustomerModel {
    private final String customerId;
    private final String name;
    private final String dateOfBirth;

    public CustomerModel(String customerId, String name, String dateOfBirth) {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerModel that = (CustomerModel) o;
        return Objects.equals(customerId, that.customerId) && Objects.equals(name, that.name) && Objects.equals(dateOfBirth, that.dateOfBirth);
    }


    @Override
    public int hashCode() {
        return Objects.hash(customerId, name, dateOfBirth);
    }

    public static Builder builder() {
        return new Builder();
    }
    public static class Builder {
        private String customerId;
        private String name;
        private String dateOfBirth;

        public Builder withId(String customerId) {
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

        public CustomerModel build() {
            return new CustomerModel(customerId, name, dateOfBirth);
        }
    }
}

