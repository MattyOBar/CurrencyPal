package com.nashss.se.currencypalservice.dynamodb.DAO;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.nashss.se.currencypalservice.dynamodb.models.Customer;
import com.nashss.se.currencypalservice.metrics.MetricsConstants;
import com.nashss.se.currencypalservice.metrics.MetricsPublisher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.MockitoAnnotations.openMocks;

class CustomerDAOTest {
    @Mock
    private DynamoDBMapper dynamoDBMapper;
    @Mock
    private MetricsPublisher metricsPublisher;

    private CustomerDAO customerDAO;

    @BeforeEach
    public void setup() {
        openMocks(this);
        customerDAO = new CustomerDAO(dynamoDBMapper, metricsPublisher);
    }

    @Test
    public void getCustomer_withId() {
        //GIVEN
        String testCustomerId = "00000";
        when(dynamoDBMapper.load(Customer.class, testCustomerId)).thenReturn(new Customer());
        //WHEN
        Customer customer = customerDAO.getCustomerActivity(testCustomerId);
        //THEN
        assertNotNull(customer);
        verify(dynamoDBMapper).load(Customer.class, testCustomerId);
        verify(metricsPublisher).addCount(eq(MetricsConstants.GETCUSTOMER_CUSTOMERNOTFOUND_COUNT), anyDouble());
    }
}