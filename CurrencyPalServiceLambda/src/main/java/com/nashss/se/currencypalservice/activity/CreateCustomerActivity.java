package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.CreateCustomerRequest;
import com.nashss.se.currencypalservice.activity.results.CreateCustomerResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.CustomerDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Customer;
import com.nashss.se.currencypalservice.exceptions.CustomerNotFoundException;
import com.nashss.se.currencypalservice.models.CustomerModel;
import com.nashss.se.currencypalservice.utils.CurrencyPalServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;


public class CreateCustomerActivity {
    private final Logger log = LogManager.getLogger();
    private final CustomerDAO customerDAO;

    @Inject
    public CreateCustomerActivity(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    public CreateCustomerResult handleRequest(final CreateCustomerRequest createCustomerRequest) throws InvalidAttributeValueException {
        log.info("Received CreateCustomerRequest {}", createCustomerRequest);

        if (!CurrencyPalServiceUtil.isValidString(createCustomerRequest.getCustomerId())) {
            throw new InvalidAttributeValueException("CustomerId " + createCustomerRequest.getCustomerId() +
                    "contains illegal characters.");
        }

        if (!CurrencyPalServiceUtil.isValidString(createCustomerRequest.getName())) {
            throw new InvalidAttributeValueException("CustomerName " + createCustomerRequest.getName() +
                    " contains illegal characters.");
        }

        Customer newCustomer = new Customer();

        newCustomer.setCustomerId(CurrencyPalServiceUtil.generateCustomerId());
        newCustomer.setName(createCustomerRequest.getName());
        newCustomer.setDateOfBirth(createCustomerRequest.getDateOfBirth());

        customerDAO.saveCustomer(newCustomer);

        CustomerModel customerModel = new ModelConverter().toCustomerModel(newCustomer);
        return CreateCustomerResult.builder()
                .withCustomerId(customerModel)
                .build();

    }

}
