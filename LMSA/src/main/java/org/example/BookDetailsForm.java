package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.util.Date;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.time.LocalDate;

public class BookDetailsForm extends Application {

    private TextField barcodeTextField = new TextField();
    private CheckBox isReferenceOnlyCheckBox = new CheckBox("Is Reference Only");
    private DatePicker borrowedDatePicker = new DatePicker();
    private DatePicker dueDatePicker = new DatePicker();
    private TextField priceTextField = new TextField();
    private ComboBox<BookFormat> formatComboBox = new ComboBox<>();
    private ComboBox<BookStatus> statusComboBox = new ComboBox<>();
    private DatePicker dateOfPurchaseDatePicker = new DatePicker();
    private DatePicker publicationDatePicker = new DatePicker();
    private TextField rackTextField = new TextField(); // Assuming Rack is represented as a String

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Book Details Form");

        //Setting to default
        dateOfPurchaseDatePicker.setValue(LocalDate.now());
        borrowedDatePicker.setValue(LocalDate.now());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels
        Label barcodeLabel = new Label("Barcode:");
        Label borrowedLabel = new Label("Borrowed:");
        Label dueDateLabel = new Label("Due Date:");
        Label priceLabel = new Label("Price:");
        Label formatLabel = new Label("Format:");
        Label statusLabel = new Label("Status:");
        Label dateOfPurchaseLabel = new Label("Date of Purchase:");
        Label publicationDateLabel = new Label("Publication Date:");
        Label rackLabel = new Label("Rack:");

        // Add labels and input fields to the grid
        grid.add(barcodeLabel, 0, 0);
        grid.add(barcodeTextField, 1, 0);

        grid.add(isReferenceOnlyCheckBox, 0, 1, 2, 1);

        grid.add(borrowedLabel, 0, 2);
        grid.add(borrowedDatePicker, 1, 2);

        grid.add(dueDateLabel, 0, 3);
        grid.add(dueDatePicker, 1, 3);

        grid.add(priceLabel, 0, 4);
        grid.add(priceTextField, 1, 4);

        grid.add(formatLabel, 0, 5);
        grid.add(formatComboBox, 1, 5);

        grid.add(statusLabel, 0, 6);
        grid.add(statusComboBox, 1, 6);

        grid.add(dateOfPurchaseLabel, 0, 7);
        grid.add(dateOfPurchaseDatePicker, 1, 7);

        grid.add(publicationDateLabel, 0, 8);
        grid.add(publicationDatePicker, 1, 8);

        grid.add(rackLabel, 0, 9);
        grid.add(rackTextField, 1, 9);

        // Set up combo box items
        formatComboBox.getItems().addAll(BookFormat.values());
        statusComboBox.getItems().addAll(BookStatus.values());

        // Buttons
        Button saveButton = new Button("Save");
        Button updateButton = new Button("Update");
        Button cancelButton = new Button("Cancel");

        // Event handler for the Save button (replace with your logic)
        saveButton.setOnAction(event -> {
            saveBookDetails();
        });

        // Event handler for the Update button (replace with your logic)
        updateButton.setOnAction(event -> {
            updateBookDetails();
        });

        // Event handler for the Cancel button
        cancelButton.setOnAction(event -> {
            primaryStage.close(); // Close the window
        });

        // Add buttons to an HBox for horizontal arrangement
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(saveButton, updateButton, cancelButton);

        // Add the button box to the grid
        grid.add(buttonBox, 0, 10, 3, 1);

        Scene scene = new Scene(grid, 400, 500);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void saveBookDetails() {
        String barcode = barcodeTextField.getText();
        boolean isReferenceOnly = isReferenceOnlyCheckBox.isSelected();
        LocalDate borrowed = borrowedDatePicker.getValue();
        LocalDate dueDate = dueDatePicker.getValue();
        double price=0;
        if (!priceTextField.getText().isEmpty()){
         price= Double.parseDouble(priceTextField.getText());}
        else {

        }
        BookFormat format = formatComboBox.getValue();
        BookStatus status = statusComboBox.getValue();
        LocalDate dateOfPurchase = dateOfPurchaseDatePicker.getValue();
        LocalDate publicationDate = publicationDatePicker.getValue();
        String rack = rackTextField.getText();

        // Use the data as needed (e.g., save to database)
        System.out.println("Saving book details: " + barcode + " - " + isReferenceOnly + " - " +
                borrowed + " - " + dueDate + " - " + price + " - " + format + " - " +
                status + " - " + dateOfPurchase + " - " + publicationDate + " - " + rack);
    }

    private void updateBookDetails() {
        String barcode = barcodeTextField.getText();
        boolean isReferenceOnly = isReferenceOnlyCheckBox.isSelected();
        LocalDate borrowed = borrowedDatePicker.getValue();
        LocalDate dueDate = dueDatePicker.getValue();
        double price=0;
        if (!priceTextField.getText().isEmpty()) {
         price=Double.parseDouble(priceTextField.getText());
        }
        BookFormat format = formatComboBox.getValue();
        BookStatus status = statusComboBox.getValue();
        LocalDate dateOfPurchase = dateOfPurchaseDatePicker.getValue();
        LocalDate publicationDate = publicationDatePicker.getValue();
        String rack = rackTextField.getText();

        // Use the data as needed (e.g., update in the database)

                System.out.println("Updating book details: " + barcode + " - " + isReferenceOnly + " - " +
                        borrowed + " - " + dueDate + " - " + price + " - " + format + " - " +
                        status + " - " + dateOfPurchase + " - " + publicationDate + " - " + rack);
    }
}
