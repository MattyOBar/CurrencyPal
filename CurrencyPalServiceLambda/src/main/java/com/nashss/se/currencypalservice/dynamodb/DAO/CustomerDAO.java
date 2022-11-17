package com.nashss.se.currencypalservice.dynamodb.DAO;

import com.nashss.se.currencypalservice.dynamodb.models.Customer;
import com.nashss.se.currencypalservice.exceptions.CustomerNotFoundException;
import com.nashss.se.currencypalservice.metrics.MetricsConstants;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class CustomerDAO {

    private DynamoDBMapper dynamoDBMapper;
    private MetricsPublisher metricsPublisher;

    /**./grad
     * Instantiates a CurrencyDao object.
     *
     * @param dynamoDBMapper   the link used to interact with the Currency table
     * @param metricsPublisher the link used to record metrics
     */

    public CustomerDAO(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }
    /**
     * Makes a DynamoDB call to retrieve the Customer.
     * @param customerId the parameter that indicates the Customer
     * @return the currency Object retrieved from DynamoDB
     */
    public Customer getCustomerActivity(String customerId) {
        Customer customer = this.dynamoDBMapper.load(Customer.class, customerId);
        if (customer == null) {
            metricsPublisher.addCount(MetricsConstants.GETCUSTOMER_CUSTOMERNOTFOUND_COUNT, 1);
            throw new CustomerNotFoundException("Could not find customer with id:" + customerId);
        }
        metricsPublisher.addCount(MetricsConstants.GETCUSTOMER_CUSTOMERNOTFOUND_COUNT, 0);
        return customer;
    }

    /**
     * Makes a DynamoDB call to retrieve and update a Customer.
     * @param customerId the parameter used to specify the Customer to retrieve
     * @param name the parameter used to specify the name linked to the customerId
     * @param dateOfBirth the parameter used to specify the age/confirmation of the customer
     * @return the new updated currency object
     */
    public Customer updateCustomer(String customerId, String name, String dateOfBirth) {
        Customer customer = this.dynamoDBMapper.load(Customer.class, customerId, name);
        if (customer == null) {
            metricsPublisher.addCount(MetricsConstants.UPDATECUSTOMER_CUSTOMERNOTFOUND_COUNT, 1);
            throw new CustomerNotFoundException("Could not find customer with id:" + customerId);
        } else {
            customer.setCustomerId(customerId);
            customer.setCustomerId(name);
            customer.setCustomerId(dateOfBirth);
            this.dynamoDBMapper.save(customer);
        }
        metricsPublisher.addCount(MetricsConstants.UPDATECUSTOMER_CUSTOMERNOTFOUND_COUNT, 0);
        return customer;
    }
}
