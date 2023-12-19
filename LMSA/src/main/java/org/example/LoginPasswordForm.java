package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LoginPasswordForm extends Application {

    private TextField usernameTextField = new TextField();
    private PasswordField passwordField = new PasswordField();
    private CheckBox rememberMeCheckbox = new CheckBox("Remember Me");
    private Button loginButton = new Button("Login");
    private Button cancelButton = new Button("Cancel");
    private Button createButton = new Button("Creat Account");

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20, 20, 20, 20));
        grid.setVgap(10);
        grid.setHgap(10);
        // Add labels, text fields, checkbox, and buttons to the grid
        grid.add(new Label("Username:"), 0, 0);
        grid.add(usernameTextField, 1, 0);

        grid.add(new Label("Password:"), 0, 1);
        grid.add(passwordField, 1, 1);

        grid.add(rememberMeCheckbox, 0, 2, 2, 1);

        grid.add(loginButton, 0, 3);
        grid.add(cancelButton, 1, 3);
        grid.add(createButton,0,4,2,4);

        // Add event handler for the Login button
        loginButton.setOnAction(e -> handleLogin());
        // Add event handler for the Login button
        cancelButton.setOnAction(actionEvent -> closeApplication(primaryStage));
        // Add event handler for the Create account button
        createButton.setOnAction(actionEvent -> new PersonDetailsForm().start(new Stage()));

        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void handleLogin() {
        String username = usernameTextField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            // Show a warning window if either the username or password is empty
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Warning");
            alert.setHeaderText(null);
            alert.setContentText("You need to input a username and password.");
            alert.showAndWait();
        } else {
            // Perform login logic here (e.g., validate credentials)
            // You can add your custom logic for successful login
            System.out.println("Login successful!");
        }
    }
    private void closeApplication(Stage stage){
        stage.close();
    }

}
