package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class Main extends Application {
    public void start(Stage primaryStage) throws Exception {
        VBox dataView = new VBox();
        TableView<Book> tableView = new TableView<>();

        TableColumn<Book, String> isbnColumn = new TableColumn<>("ISBN");
        isbnColumn.setCellValueFactory(new PropertyValueFactory<>("ISBN"));
        TableColumn<Book, String> titleColumn = new TableColumn<>("Title");
        titleColumn.setCellValueFactory(new PropertyValueFactory<>("title"));
        tableView.getColumns().addAll(isbnColumn, titleColumn);
        dataView.getChildren().add(tableView);


        // Create the table and set the columns
        tableView = new TableView<>();







        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(10,10,10,10));
        GridPane gridPane= new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.BOTTOM_RIGHT);
        gridPane.add(new Label("Search"),0,0);
        TextField textField = new TextField();
        textField.setPromptText("Title, Author, Genre");
        gridPane.add(textField,1,0);
        gridPane.add(new Button("Search"),1,1);
        borderPane.setTop(gridPane);
        borderPane.setCenter(dataView);
        Scene scene = new Scene(borderPane, 400 ,450);
        primaryStage.setTitle("LMSs");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}