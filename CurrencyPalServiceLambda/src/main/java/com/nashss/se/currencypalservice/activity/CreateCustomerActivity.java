package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.CreateCustomerRequest;
import com.nashss.se.currencypalservice.activity.results.CreateCustomerResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.CustomerDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Customer;
import com.nashss.se.currencypalservice.models.CustomerModel;
import com.nashss.se.currencypalservice.utils.CurrencyPalServiceUtil;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;


public class CreateCustomerActivity {
    private final Logger log = LogManager.getLogger();
    private final CustomerDAO customerDAO;
    /**
     * Instantiates a new GetCurrencyActivity Object.
     *
     * @param customerDAO customerDAO to access the customer table.
     */
    @Inject
    public CreateCustomerActivity(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }
    /**
     * This method handles the incoming request by retrieving the playlist from the data base.
     * @param createCustomerRequest the request object containing the Customer.
     * @return createCustomerResult the result object containing the API defined {@link CustomerModel}.
     */
    public CreateCustomerResult handleRequest(final CreateCustomerRequest createCustomerRequest) {
        log.info("Received CreateCustomerRequest {}", createCustomerRequest);

        if (!CurrencyPalServiceUtil.isValidString(createCustomerRequest.getCustomerId())) {
            throw new InvalidAttributeValueException("CustomerId " + createCustomerRequest.getCustomerId() +
                    " contains illegal characters.");
        }

        if (!CurrencyPalServiceUtil.isValidString(createCustomerRequest.getName())) {
            try {
                throw new InvalidAttributeValueException("CustomerName " + createCustomerRequest.getName() +
                        " contains illegal characters.");
            } catch (InvalidAttributeValueException e) {
                throw new RuntimeException(e);
            }
        }

        Customer newCustomer = new Customer();

        newCustomer.setCustomerId(CurrencyPalServiceUtil.generateCustomerId());
        newCustomer.setName(createCustomerRequest.getName());
        newCustomer.setDateOfBirth(createCustomerRequest.getDateOfBirth());

        customerDAO.saveCustomer(newCustomer);

        CustomerModel customerModel = new ModelConverter().toCustomerModel(newCustomer);
        return CreateCustomerResult.builder()
                .withCustomer(customerModel)
                .build();
    }

}
