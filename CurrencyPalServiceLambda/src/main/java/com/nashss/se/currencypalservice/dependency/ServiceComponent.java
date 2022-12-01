package com.nashss.se.currencypalservice.dependency;

import com.nashss.se.currencypalservice.activity.CreateTransactionActivity;
import com.nashss.se.currencypalservice.activity.GetAllCurrencyActivity;
import com.nashss.se.currencypalservice.activity.GetCurrencyActivity;

import com.nashss.se.currencypalservice.activity.GetTransactionActivity;

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
     * @return GetAllCurrencyActivity
     */
    GetAllCurrencyActivity provideGetAllCurrencyActivity();

    /**
     * Provides the relevant activity.
     * @return GetTransactionActivity
     */
    GetTransactionActivity provideGetTransactionActivity();

    /**
     * Provides the relevant activity.
     * @return CreateTransactionActivity
     */
    CreateTransactionActivity provideCreateTransactionActivity();

    /**
     * Provides the relevant activity.
     * @return CreatePlaylistActivity
     */
    //CreateCustomerActivity provideCreatePlaylistActivity();

    /**
     * Provides the relevant activity.
     * @return GetCustomerActivity
     */
    //GetCustomerActivity provideGetCustomerActivity();

    /**
     * Provides the relevant activity.
     * @return UpdateCustomerActivity
     */
    //UpdateCustomerActivity provideUpdateCustomerActivity();
}
