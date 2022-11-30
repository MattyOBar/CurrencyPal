package com.nashss.se.currencypalservice.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class CurrencyPalServiceUtil {
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"'\\\\]");
    static final int CUSTOMER_ID_LENGTH = 5;

    private CurrencyPalServiceUtil() {
    }

    public static boolean isValidString(String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        } else {
            return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
        }
    }

    public static String generateCustomerId() {
        return RandomStringUtils.randomAlphanumeric(5);
    }
}
