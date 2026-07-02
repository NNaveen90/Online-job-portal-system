package com.jobportal.util;

public class ValidationUtil {

    public static boolean isNullOrEmpty(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidEmail(String email) {
        return email.contains("@") && email.contains(".");
    }
}