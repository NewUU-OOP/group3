package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AuthorPage extends Application {

    private TextField nameTextField = new TextField();
    private TextArea descriptionTextField = new TextArea();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Add Author Information");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(20);
        grid.setHgap(10);
        grid.prefWidth(400);
        grid.setAlignment(Pos.CENTER_RIGHT);

        // Labels
        Label nameLabel = new Label("Author Name:");

        Label descriptionLabel = new Label("Description:");

        grid.add(nameLabel, 0, 0);
        grid.add(nameTextField, 1, 0);

        grid.add(descriptionLabel, 0, 1);
        grid.add(descriptionTextField, 1, 1);

        // Buttons
        Button addButton = new Button("Add");
        Button updateButton = new Button("Update");
        Button cancelButton = new Button("Cancel");

        // Event handler for the Add button (replace with your logic)
        addButton.setOnAction(event -> {
            String name = nameTextField.getText();
            String description = descriptionTextField.getText();
            System.out.println("Adding item: " + name + " - " + description);
            // Add your logic for adding the item here
        });

        // Event handler for the Update button (replace with your logic)
        updateButton.setOnAction(event -> {
            String name = nameTextField.getText();
            String description = descriptionTextField.getText();
            System.out.println("Updating item: " + name + " - " + description);
            // Add your logic for updating the item here
        });

        // Event handler for the Cancel button (replace with your logic)
        cancelButton.setOnAction(event -> {
            nameTextField.clear();
            descriptionTextField.clear();
            primaryStage.close();
            // Add your logic for canceling here
        });

        // Add buttons to an HBox for horizontal arrangement
        HBox buttonBox = new HBox(10);
        buttonBox.getChildren().addAll(addButton, updateButton, cancelButton);

        // Add the button box to the grid
        grid.add(buttonBox, 0, 2, 2, 1);

        Scene scene = new Scene(grid, 400, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }
}
