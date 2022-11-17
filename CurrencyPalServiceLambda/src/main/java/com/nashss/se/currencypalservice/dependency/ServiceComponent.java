package com.nashss.se.currencypalservice.dependency;

import com.nashss.se.currencypalservice.activity.CreateCustomerActivity;

import com.nashss.se.currencypalservice.activity.GetCustomerActivity;
import com.nashss.se.currencypalservice.activity.UpdateCustomerActivity;

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

    /**
     * Provides the relevant activity.
     * @return CreatePlaylistActivity
     */
    CreateCustomerActivity provideCreatePlaylistActivity();

    /**
     * Provides the relevant activity.
     * @return GetCustomerActivity
     */
    GetCustomerActivity provideGetCustomerActivity();

    /**
     * Provides the relevant activity.
     * @return UpdateCustomerActivity
     */
    UpdateCustomerActivity provideUpdateCustomerActivity();
}
