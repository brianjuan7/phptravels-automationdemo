package org.brianjuan.utilities;

public class Faker {
    private static final com.github.javafaker.Faker fakerField = new com.github.javafaker.Faker();

    private Faker() { }

    public static String generateEmail() {
        return fakerField.internet().emailAddress();
    }

    public static String generateFirstName() {
        return fakerField.name().firstName();
    }

    public static String generateLastName() {
        return fakerField.name().lastName();
    }
}
