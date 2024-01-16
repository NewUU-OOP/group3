package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class RandomData {

        public static void insertDB() throws SQLException {
            int numberOfRecords = 1000000; // Change this to the desired number of records

            for (int i = 0; i < numberOfRecords; i++) {
                String isbn = generateRandomISBN();
                String title = generateRandomTitle();
                String subject = generateRandomSubject();
                String publisher = generateRandomPublisher();
                int language = generateRandomLanguage();
                int pages = generateRandomPages();

                // Assuming you have a method to insert data into your database or perform any other desired action
                DatabaseConnection.saveData("INSERT INTO bookinfo (isbn, title, subject, publisher, language, pages)" +
                        "VALUES ('"+isbn+"', '"+title+"','"+subject+"'," +
                        "'"+publisher+"','"+language+"','"+pages+"')");
            }
        }

        public static void main(String[] args) throws SQLException {

        }

        private static String generateRandomISBN() {
            // Implement your logic to generate a random ISBN
            // For simplicity, let's generate a 13-digit random number
            return String.valueOf(new Random().nextLong()).substring(1, 10);
        }

        private static String generateRandomTitle() {
            // Implement your logic to generate a random title
            String title =generateRandomString(8,16);
            return title;
        }

        private static String generateRandomSubject() {
            // Implement your logic to generate a random subject
            String[] subjects = {"Fiction", "Science Fiction", "Mystery", "Romance", "Biography & Memoir", "Historical Fiction", "Classics"};
            return subjects[new Random().nextInt(subjects.length)];
        }

        private static String generateRandomPublisher() {
            // Implement your logic to generate a random publisher
            String[] publishers = {"HarperCollins", "Penguin Books", "Back Bay Books", "Scribner", "Anchor", "Riverhead Books", "Simon & Schuster", "Vintage Crime/Black Lizard"};
            return publishers[new Random().nextInt(publishers.length)];
        }

        private static int generateRandomLanguage() {
            // Implement your logic to generate a random language code between 1 and 5
            return new Random().nextInt(5) + 1;
        }

        private static int generateRandomPages() {
            // Implement your logic to generate a random number of pages
            return new Random().nextInt(500) + 100; // Random number between 100 and 599
        }

        private static void insertData(String isbn, String title, String subject, String publisher, int language, int pages) {
            // Implement your logic to insert data into your database or perform any other desired action
            System.out.println("Inserting data: ISBN=" + isbn + ", Title=" + title + ", Subject=" + subject +
                    ", Publisher=" + publisher + ", Language=" + language + ", Pages=" + pages);
        }



        private static String generateRandomString(int minLength, int maxLength) {
            int stringLength = new Random().nextInt(maxLength - minLength + 1) + minLength;
            StringBuilder randomString = new StringBuilder();

            for (int i = 0; i < stringLength; i++) {
                char randomChar = generateRandomCharacter();
                randomString.append(randomChar);
            }

            return randomString.toString();
        }

        private static char generateRandomCharacter() {
            String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
            int index = new Random().nextInt(characters.length());
            return characters.charAt(index);
        }



}
