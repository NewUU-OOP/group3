package org.example;

import java.security.SecureRandom;

public final class BarcodeGenerator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int DEFAULT_BARCODE_LENGTH = 12;

    public static String generateBarcode() {
        return generateBarcode(DEFAULT_BARCODE_LENGTH);
    }

    public static String generateBarcode(int length) {
        if (length <= 0) {
            throw new IllegalArgumentException("Barcode length must be greater than zero.");
        }

        StringBuilder barcode = new StringBuilder();
        SecureRandom random = new SecureRandom();

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            barcode.append(CHARACTERS.charAt(randomIndex));
        }

        return barcode.toString();
    }

    public static void main(String[] args) {
        // Example of generating a barcode with the default length
        String generatedBarcode = generateBarcode();
        System.out.println("Generated Barcode: " + generatedBarcode);

        // Example of generating a barcode with a custom length
        String customBarcode = generateBarcode(15);
        System.out.println("Custom Barcode: " + customBarcode);
    }
}
