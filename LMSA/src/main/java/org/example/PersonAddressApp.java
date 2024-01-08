package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class PersonAddressApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Person and Address Form");

        // Person Form
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Button savePersonButton = new Button("Save Person");

        // Address Form
        Label streetAddressLabel = new Label("Street Address:");
        TextField streetAddressField = new TextField();
        Label cityLabel = new Label("City:");
        TextField cityField = new TextField();
        Label stateLabel = new Label("State:");
        TextField stateField = new TextField();
        Label zipCodeLabel = new Label("Zip Code:");
        TextField zipCodeField = new TextField();
        Label countryLabel = new Label("Country:");
        TextField countryField = new TextField();
        Button saveAddressButton = new Button("Save Address");

        // Layout
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameField, 1, 0);
        gridPane.add(savePersonButton, 2, 0);

        gridPane.add(streetAddressLabel, 0, 1);
        gridPane.add(streetAddressField, 1, 1);
        gridPane.add(cityLabel, 0, 2);
        gridPane.add(cityField, 1, 2);
        gridPane.add(stateLabel, 0, 3);
        gridPane.add(stateField, 1, 3);
        gridPane.add(zipCodeLabel, 0, 4);
        gridPane.add(zipCodeField, 1, 4);
        gridPane.add(countryLabel, 0, 5);
        gridPane.add(countryField, 1, 5);
        gridPane.add(saveAddressButton, 2, 5);

        Scene scene = new Scene(gridPane, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}

