package com.nashss.se.currencypalservice.dynamodb.models;

public enum CurrencyType {
    US_DOLLAR("USD", "United States Dollars", "$"),
    SWISS_FRANC("CHF", "Swiss Franc", "CHF"),
    EURO("EUR", "Euro","€"),
    JAPANESE_YEN("JPY", "Japanese Yen", "¥"),
    BULGARIAN_LEV("BGN", "Bulgarian Lev", "BGN"),
    CZECH_REPUBLIC_KORUNA("CZK", "Czech Republic Koruna", "Kč"),
    DANISH_KRONE("DKR", "Dannish Krone", "Dkr"),
    BRITISH_POUND_STERLING("GBP", "British Pound Sterling", "£"),
    HUNGARIAN_FORINT("HUF", "Hungarian Forint", "Ft"),
    POLISH_ZLOTY("PLN", "Polish Zloty", "zł");

    private String currencyAbrv;
    private String currencyName;
    private String currencySymbol;

     CurrencyType(String currencyAbrv, String currencyName, String currencySymbol) {
        this.currencyAbrv = currencyAbrv;
        this.currencyName = currencyName;
        this.currencySymbol = currencySymbol;
    }

    public String getCurrencyType() {
        return this.currencyAbrv + this.currencyName + this.currencySymbol;
    }

    public String getCurrencyAbrv() {
        return currencyAbrv;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public String getCurrencySymbol() {
        return currencySymbol;
    }
}
