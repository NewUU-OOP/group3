package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class VisibleBordersExample extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Visible Borders Example");

        // Create a BorderPane
        BorderPane borderPane = new BorderPane();

        // Create labels for each region
        Label topLabel = new Label("Top");
        Label rightLabel = new Label("Right");
        Label bottomLabel = new Label("Bottom");
        Label leftLabel = new Label("Left");
        Label centerLabel = new Label("Center");
        borderPane.setBorder(new Border(new BorderStroke(Color.BROWN, BorderStrokeStyle.SOLID, CornerRadii.EMPTY,BorderWidths.DEFAULT)));

        // Set borders for each region
        borderPane.setTop(topLabel);

        borderPane.setRight(rightLabel);

        borderPane.setBottom(bottomLabel);

        borderPane.setLeft(leftLabel);

        borderPane.setCenter(centerLabel);

        // Set padding for the BorderPane
        borderPane.setPadding(new Insets(10));

        // Create a Scene
        Scene scene = new Scene(borderPane, 400, 300);

        // Set the Scene
        primaryStage.setScene(scene);

        // Show the Stage
        primaryStage.show();
    }
}
