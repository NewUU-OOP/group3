package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.SQLException;

public class AddressFormApp extends Application {

    private TextField streetAddressField = new TextField();
    private TextField cityField = new TextField();
    private TextField stateField = new TextField();
    private TextField zipCodeField = new TextField();
    private TextField countryField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setTitle("Address Form");

        // Create labels
        Label streetAddressLabel = new Label("Street Address:");
        Label cityLabel = new Label("City:");
        Label stateLabel = new Label("State:");
        Label zipCodeLabel = new Label("Zip Code:");
        Label countryLabel = new Label("Country:");
        //Initial text for testing
        streetAddressField.setText("Main Street, 12");
        cityField.setText("Tashkent");
        stateField.setText("Tashkent");
        zipCodeField.setText("123121");
        countryField.setText("Uzbekistan");
        // Create a GridPane layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        // Add labels and fields to the grid
        gridPane.add(streetAddressLabel, 0, 0);
        gridPane.add(streetAddressField, 1, 0);
        gridPane.add(cityLabel, 0, 1);
        gridPane.add(cityField, 1, 1);
        gridPane.add(stateLabel, 0, 2);
        gridPane.add(stateField, 1, 2);
        gridPane.add(zipCodeLabel, 0, 3);
        gridPane.add(zipCodeField, 1, 3);
        gridPane.add(countryLabel, 0, 4);
        gridPane.add(countryField, 1, 4);

        // Create buttons
        Button saveButton = new Button("Save");
        Button editButton = new Button("Edit");
        Button cancelButton = new Button("Cancel");

        // Add event handlers for the buttons
        saveButton.setOnAction(e -> {
            // Handle save logic here
            System.out.println("Save button clicked");
            try {
                DatabaseConnection.saveData("INSERT INTO Address (streetAddress, city, state, zipCode, country)" +
                        "VALUES" +
                        "('"+streetAddressField.getText()+"', '"+cityField.getText()+"', '"+stateField.getText()+"', '"+zipCodeField.getText()+"', '"+countryField.getText()+"')");
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });

        editButton.setOnAction(e -> {
            // Handle edit logic here
            System.out.println("Edit button clicked");
        });

        cancelButton.setOnAction(e -> {
            // Handle cancel logic here
            System.out.println("Cancel button clicked");
        });

        // Add buttons to the grid
        gridPane.add(saveButton, 0, 5);
        gridPane.add(editButton, 1, 5);
        gridPane.add(cancelButton, 2, 5);

        // Create a scene and set it on the stage
        Scene scene = new Scene(gridPane, 400, 250);
        primaryStage.setScene(scene);

        // Show the stage
        primaryStage.show();
    }
}
