package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.time.LocalDate;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class BookDetailsForm extends Application {
    public void customNode(String stageTitle){
        Stage primaryStage = new Stage();
        TextField isbnTextField = new TextField();
        TextField barcodeTextField = new TextField();
        CheckBox isReferenceOnlyCheckBox = new CheckBox("Is Reference Only");
        DatePicker borrowedDatePicker = new DatePicker();
        DatePicker dueDatePicker = new DatePicker();
        TextField priceTextField = new TextField();
        ComboBox<BookFormat> formatComboBox = new ComboBox<>();
        ComboBox<BookStatus> statusComboBox = new ComboBox<>();
        DatePicker dateOfPurchaseDatePicker = new DatePicker();
        DatePicker publicationDatePicker = new DatePicker();
        TextField rackTextField = new TextField(); // Assuming Rack is represented as a String
        GridPane rightView = new GridPane();
        rightView.setPadding(new Insets(20, 20, 20, 20));
        rightView.setVgap(10);
        rightView.setHgap(10);
        Label titleLabel = new Label("Title:");
        Label authorLabel = new Label("Author:");
        Label languageLabel = new Label("Language:");
        rightView.add(titleLabel, 0, 1);
        rightView.add(authorLabel, 0, 2);
        rightView.add(languageLabel, 0, 3);
        rightView.setAlignment(Pos.TOP_LEFT);

        BorderPane borderPane = new BorderPane();

        borderPane.setRight(rightView);
        borderPane.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        primaryStage.setTitle("Book Details Form");
        //Set recommended barcode for book
        barcodeTextField.setText(BarcodeGenerator.generateBarcode());

        //Setting to default
        dateOfPurchaseDatePicker.setValue(LocalDate.now());
        borrowedDatePicker.setValue(LocalDate.now());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels
        Label isbnLabel = new Label("ISBN:");
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
        grid.add(isbnLabel, 0, 0);
        grid.add(isbnTextField, 1, 0);

        grid.add(barcodeLabel, 0, 1);
        grid.add(barcodeTextField, 1, 1);

        grid.add(isReferenceOnlyCheckBox, 0, 2, 2, 1);

        grid.add(borrowedLabel, 0, 3);
        grid.add(borrowedDatePicker, 1, 3);

        grid.add(dueDateLabel, 0, 4);
        grid.add(dueDatePicker, 1, 4);

        grid.add(priceLabel, 0, 5);
        grid.add(priceTextField, 1, 5);

        grid.add(formatLabel, 0, 6);
        grid.add(formatComboBox, 1, 6);

        grid.add(statusLabel, 0, 7);
        grid.add(statusComboBox, 1, 7);

        grid.add(dateOfPurchaseLabel, 0, 8);
        grid.add(dateOfPurchaseDatePicker, 1, 8);

        grid.add(publicationDateLabel, 0, 9);
        grid.add(publicationDatePicker, 1, 9);

        grid.add(rackLabel, 0, 10);
        grid.add(rackTextField, 1, 10);

        // Set up combo box items
        formatComboBox.getItems().addAll(BookFormat.values());
        statusComboBox.getItems().addAll(BookStatus.values());

        // Buttons
        Button saveButton = new Button("Save");
        Button updateButton = new Button("Update");
        Button cancelButton = new Button("Cancel");

        // Event handler for the Save button (replace with your logic)
        saveButton.setOnAction(event -> {
            try {
                saveBookDetails();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
        grid.add(buttonBox, 0, 11, 3, 1);
        borderPane.setCenter(grid);

        Scene scene = new Scene(borderPane, 700, 600);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

    private TextField isbnTextField = new TextField();
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



    @Override
    public void start(Stage primaryStage) {

        GridPane rightView = new GridPane();
        rightView.setPadding(new Insets(20, 20, 20, 20));
        rightView.setVgap(10);
        rightView.setHgap(10);
        Label titleLabel = new Label("Title:");
        Label authorLabel = new Label("Author:");
        Label languageLabel = new Label("Language:");
        rightView.add(titleLabel, 0, 1);
        rightView.add(authorLabel, 0, 2);
        rightView.add(languageLabel, 0, 3);
        rightView.setAlignment(Pos.TOP_LEFT);

        BorderPane borderPane = new BorderPane();

        borderPane.setRight(rightView);
        borderPane.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        primaryStage.setTitle("Book Details Form");
        //Set recommended barcode for book
        barcodeTextField.setText(BarcodeGenerator.generateBarcode());

        //Setting to default
        dateOfPurchaseDatePicker.setValue(LocalDate.now());
        borrowedDatePicker.setValue(LocalDate.now());

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels
        Label isbnLabel = new Label("ISBN:");
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
        grid.add(isbnLabel, 0, 0);
        grid.add(isbnTextField, 1, 0);

        grid.add(barcodeLabel, 0, 1);
        grid.add(barcodeTextField, 1, 1);

        grid.add(isReferenceOnlyCheckBox, 0, 2, 2, 1);

        grid.add(borrowedLabel, 0, 3);
        grid.add(borrowedDatePicker, 1, 3);

        grid.add(dueDateLabel, 0, 4);
        grid.add(dueDatePicker, 1, 4);

        grid.add(priceLabel, 0, 5);
        grid.add(priceTextField, 1, 5);

        grid.add(formatLabel, 0, 6);
        grid.add(formatComboBox, 1, 6);

        grid.add(statusLabel, 0, 7);
        grid.add(statusComboBox, 1, 7);

        grid.add(dateOfPurchaseLabel, 0, 8);
        grid.add(dateOfPurchaseDatePicker, 1, 8);

        grid.add(publicationDateLabel, 0, 9);
        grid.add(publicationDatePicker, 1, 9);

        grid.add(rackLabel, 0, 10);
        grid.add(rackTextField, 1, 10);

        // Set up combo box items
        formatComboBox.getItems().addAll(BookFormat.values());
        statusComboBox.getItems().addAll(BookStatus.values());

        // Buttons
        Button saveButton = new Button("Save");
        Button updateButton = new Button("Update");
        Button cancelButton = new Button("Cancel");

        // Event handler for the Save button (replace with your logic)
        saveButton.setOnAction(event -> {
            try {
                saveBookDetails();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
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
        grid.add(buttonBox, 0, 11, 3, 1);
        borderPane.setCenter(grid);


        Scene scene = new Scene(borderPane, 700, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void saveBookDetails() throws SQLException {
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

        DatabaseConnection.saveData("INSERT INTO LibraryBook (barcode, isReferenceOnly, borrowed, dueDate, price, format, status, dateOfPurchase, publicationDate, placedAt)" +
                "VALUES ('"+barcode+"', "+isReferenceOnly+", '"+borrowed+"', '"+dueDate.toString()+"', "+price+", '"+format.toString()+"', '"+status.toString()+"', '"+dateOfPurchase+"', '"+publicationDate+"', '"+rack+"');");

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
