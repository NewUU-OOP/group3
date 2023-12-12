package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));
        gridPane.add(new Label("Title"),0,0);
        Scene scene = new Scene(gridPane, 400 ,450);
        primaryStage.setTitle("LMSs");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}