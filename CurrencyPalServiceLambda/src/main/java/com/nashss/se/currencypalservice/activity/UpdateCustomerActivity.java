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

import javax.inject.Inject;
import javax.management.InvalidAttributeValueException;

public class UpdateCustomerActivity {
    private final Logger log = LogManager.getLogger();
    private final CustomerDAO customerDAO;
    private final MetricsPublisher metricsPublisher;

    /**
     * Instantiates a new GetCurrencyActivity Object.
     *
     * @param customerDAO customerDAO  to access the currency table.
     * @param metricsPublisher metrics to be published.
     */
    @Inject
    public UpdateCustomerActivity(CustomerDAO customerDAO, MetricsPublisher metricsPublisher) {
        this.customerDAO = customerDAO;
        this.metricsPublisher = metricsPublisher;
    }

    /**
     * This method handles the incoming request by retrieving the customer from the data base.
     * @param updateCustomerRequest the request object containing the customerId.
     * @return updateCustomerResult the result object containing the API defined {@link CustomerModel}.
     */
    public UpdateCustomerResult handleRequest(final UpdateCustomerRequest updateCustomerRequest) {
        log.info("Received updateCustomerRequest {}", updateCustomerRequest);

        if (!CurrencyPalServiceUtil.isValidString(updateCustomerRequest.getCustomerId())) {

            try {
                throw new InvalidAttributeValueException("CustomerID" + updateCustomerRequest.getCustomerId() +
                        " contains an illegal character");
            } catch (InvalidAttributeValueException e) {
                throw new RuntimeException(e);
            }
        }

        Customer customer = customerDAO.getCustomerActivity(updateCustomerRequest.getCustomerId());

        if (!customer.getCustomerId().equals(updateCustomerRequest.getCustomerId())) {

            try {
                throw new InvalidAttributeValueException("Can not change customer ID [ " +
                        customer.getCustomerId() + " ] of the customer.");
            } catch (InvalidAttributeValueException e) {
                throw new RuntimeException(e);
            }
        }

        customer.setName(updateCustomerRequest.getName());
        customer.setDateOfBirth(updateCustomerRequest.getDateOfBirth());
        customer = customerDAO.saveCustomer(customer);

        return UpdateCustomerResult.builder()
                .withCustomer(new ModelConverter().toCustomerModel(customer))
                .build();
    }

}
