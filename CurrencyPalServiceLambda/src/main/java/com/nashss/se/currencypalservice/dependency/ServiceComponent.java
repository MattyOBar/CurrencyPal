package com.nashss.se.currencypalservice.dependency;

import com.nashss.se.currencypalservice.activity.CreateCustomerActivity;
import com.nashss.se.currencypalservice.activity.GetCurrencyActivity;
import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger component for providing dependency injection in the Music Playlist Service.
 */
@Singleton
@Component(modules = {DaoModule.class, MetricsModule.class})
public interface ServiceComponent {
    /**
     * Provides the relevant activity.
     * @return GetCurrencyActivity
     */
    GetCurrencyActivity provideGetCurrencyActivity();
}
