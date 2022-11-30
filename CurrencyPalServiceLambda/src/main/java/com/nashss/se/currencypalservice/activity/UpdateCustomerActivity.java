package com.nashss.se.currencypalservice.activity;

import com.nashss.se.currencypalservice.activity.requests.UpdateCustomerRequest;
import com.nashss.se.currencypalservice.activity.results.UpdateCustomerResult;
import com.nashss.se.currencypalservice.converters.ModelConverter;
import com.nashss.se.currencypalservice.dynamodb.DAO.CustomerDAO;
import com.nashss.se.currencypalservice.dynamodb.models.Customer;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;
import com.nashss.se.currencypalservice.utils.CurrencyPalServiceUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.management.InvalidAttributeValueException;

public class UpdateCustomerActivity {
    private final Logger log = LogManager.getLogger();
    private final CustomerDAO customerDAO;
    private final MetricsPublisher metricsPublisher;

    public UpdateCustomerActivity(CustomerDAO customerDAO, MetricsPublisher metricsPublisher) {
        this.customerDAO = customerDAO;
        this.metricsPublisher = metricsPublisher;
    }

    public UpdateCustomerResult handleRequest(final UpdateCustomerRequest updateCustomerRequest) throws InvalidAttributeValueException {
        log.info("Received updateCustomerRequest {}", updateCustomerRequest);

        if (!CurrencyPalServiceUtil.isValidString(updateCustomerRequest.getCustomerId())) {

            throw new InvalidAttributeValueException("CustomerID" + updateCustomerRequest.getCustomerId() +
                    "contains an illegal character");
        }

        Customer customer = customerDAO.getCustomerActivity(updateCustomerRequest.getCustomerId());

        if (!customer.getCustomerId().equals(updateCustomerRequest.getCustomerId())) {

            throw new InvalidAttributeValueException("Can not change " + customer.getCustomerId());
        }

        customer.setName(updateCustomerRequest.getName());
        customer.setDateOfBirth(updateCustomerRequest.getDateOfBirth());
        customer = customerDAO.saveCustomer(customer);

        return UpdateCustomerResult.builder()
                .withCustomer(new ModelConverter().toCustomerModel(customer))
                .build();
    }

}
