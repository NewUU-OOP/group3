package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;

public class PersonDetailsForm extends Application {

    private TextField nameTextField = new TextField();
    private TextField emailTextField = new TextField();
    private TextField phoneTextField = new TextField();
    private TextField addressTexField = new TextField();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        nameTextField.setPrefWidth(150);
        phoneTextField.setPrefWidth(150);
        emailTextField.setPrefWidth(150);
        primaryStage.setTitle("Person Details Form");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);

        // Labels
        Label nameLabel = new Label("Name:");
        Label addressLabel  = new Label("Address:");
        Label emailLabel = new Label("Email:");
        Label phoneLabel = new Label("Phone:");

        // Add labels and text fields to the grid
        grid.add(nameLabel, 0, 0);
        grid.add(nameTextField, 1, 0);
        grid.add(addressLabel, 0,1);
        grid.add(addressTexField,1,1);

        grid.add(emailLabel, 0, 2);
        grid.add(emailTextField, 1, 2);

        grid.add(phoneLabel, 0, 3);
        grid.add(phoneTextField, 1, 3);





        // Buttons
        Button saveButton = new Button("Save");
        Button cancelButton = new Button("Cancel");

        // Event handler for the Save button (replace with your logic)
        saveButton.setOnAction(event -> {
            savePersonDetails();
        });

        // Event handler for the Cancel button
        cancelButton.setOnAction(event -> {
            primaryStage.close(); // Close the window
        });

        // Add buttons to an HBox for horizontal arrangement
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(saveButton, cancelButton);

        // Add the button box to the grid
        grid.add(buttonBox, 0, 4, 4, 1); // span 3 columns

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void savePersonDetails() {
        String name = nameTextField.getText();
        String email = emailTextField.getText();
        String phone = phoneTextField.getText();

        // Use the data as needed (e.g., save to database)
        System.out.println("Saving person details: " + name + " - " + email + " - " + phone);
    }
}

