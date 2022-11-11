package com.nashss.se.currencypalservice.dynamodb.DAO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.currencypalservice.dynamodb.models.Customer;
import com.nashss.se.currencypalservice.exceptions.CustomerNotFound;
import com.nashss.se.currencypalservice.metrics.MetricsConstants;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;

public class CustomerDAO {

    private DynamoDBMapper dynamoDBMapper;
    private MetricsPublisher metricsPublisher;

    /**
     * Instantiates a CurrencyDao object.
     *
     * @param dynamoDBMapper   the link used to interact with the Currency table
     * @param metricsPublisher the link used to record metrics
     */

    public CustomerDAO(DynamoDBMapper dynamoDBMapper, MetricsPublisher metricsPublisher) {
        this.dynamoDBMapper = dynamoDBMapper;
        this.metricsPublisher = metricsPublisher;
    }

    public Customer getCustomerActivity(String customerId) {
        Customer customer = this.dynamoDBMapper.load(Customer.class, customerId);
        if (customer == null) {
            metricsPublisher.addCount(MetricsConstants.GETCUSTOMER_CUSTOMERNOTFOUND_COUNT, 1);
            throw new CustomerNotFound("Could not find customer with id:" + customerId);
        }
        metricsPublisher.addCount(MetricsConstants.GETCUSTOMER_CUSTOMERNOTFOUND_COUNT, 0);
        return customer;
    }

    public Customer updateCustomer(String customerId, String name, String dateOfBirth) {
        Customer customer = this.dynamoDBMapper.load(Customer.class, customerId, name);
        if (customer == null) {
            metricsPublisher.addCount(MetricsConstants.UPDATECUSTOMER_CUSTOMERNOTFOUND_COUNT, 1);
            throw new CustomerNotFound("Could not find customer with id:" + customerId);
        } else {
            customer.setCustomerId(name, dateOfBirth);
            this.dynamoDBMapper.save(customer);
        }
        metricsPublisher.addCount(MetricsConstants.UPDATECUSTOMER_CUSTOMERNOTFOUND_COUNT, 0);
        return customer;
    }
}
