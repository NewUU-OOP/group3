package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginPassword extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        TextField login = new TextField();
        TextField password = new PasswordField();
        Label loginL = new Label("Login:");
        Label passwordL = new Label("Password");

        Button loginB = new Button("Login");
        Button cancelB = new Button("Cancel");
        Button creatAB = new Button("Create Account");
        FlowPane flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.getChildren().addAll(loginB,cancelB,creatAB);
        flowPane.setAlignment(Pos.CENTER_LEFT);
        VBox vBox = new VBox();
        vBox.setPadding(new Insets(10,10,10,10));

        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.add(loginL,0,0);
        gridPane.add(login,1,0);
        gridPane.add(passwordL,0,1);
        gridPane.add(password,1,1);
       vBox.getChildren().addAll(gridPane,flowPane);
        Scene scene = new Scene(vBox,400,250);
        primaryStage.setTitle("Login Page");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
