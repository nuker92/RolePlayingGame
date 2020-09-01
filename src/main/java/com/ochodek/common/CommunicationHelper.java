package com.ochodek.common;

public class CommunicationHelper {

    public static void createMainInfo(String message) {
        System.out.printf("=============================== %s ===============================%n", message);
    }

    public static void createAdditionalInfo(String message) {
        System.out.println(message);
    }

    public static void createErrorInfo(String message) {
        System.out.printf("Error: %s %n", message);
    }

}
