package com.nashss.se.currencypalservice.utils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.regex.Pattern;

public class CurrencyPalServiceUtil {

    static final int CUSTOMER_ID_LENGTH = 5;
    private static final Pattern INVALID_CHARACTER_PATTERN = Pattern.compile("[\"'\\\\]");

    private CurrencyPalServiceUtil() {
    }
    /**
     * This method handles string validation.
     * @param stringToValidate incoming to to check if it blank or valid.
     * @return boolean to see if string is valid.
     */
    public static boolean isValidString(String stringToValidate) {
        if (StringUtils.isBlank(stringToValidate)) {
            return false;
        } else {
            return !INVALID_CHARACTER_PATTERN.matcher(stringToValidate).find();
        }
    }
    /**
     * This method handles string validation.
     * @return string with a randomly generated number.
     */
    public static String generateCustomerId() {
        return RandomStringUtils.randomAlphanumeric(CUSTOMER_ID_LENGTH);
    }
}
