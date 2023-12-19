package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LibraryManagementSystem extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Library Management System");

        BorderPane borderPane = new BorderPane();

        // Create top menu bar
        MenuBar menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitMenuItem = new MenuItem("Exit");
        exitMenuItem.setOnAction(e -> System.exit(0));
        fileMenu.getItems().add(exitMenuItem);
        menuBar.getMenus().add(fileMenu);

        // Create left-side navigation
        VBox navigationVBox = new VBox();
        navigationVBox.setPadding(new Insets(10));
        navigationVBox.setSpacing(10);

        Button addBookButton = new Button("Add Book");
        Button issueBookButton = new Button("Issue Book");
        Button returnBookButton = new Button("Return Book");
        Button viewBooksButton = new Button("View Books");

        addBookButton.setOnAction(e -> showAddBookForm());
        issueBookButton.setOnAction(e -> showIssueBookForm());
        returnBookButton.setOnAction(e -> showReturnBookForm());
        viewBooksButton.setOnAction(e -> showViewBooksTable());

        navigationVBox.getChildren().addAll(addBookButton, issueBookButton, returnBookButton, viewBooksButton);

        // Create main content area
        VBox contentVBox = new VBox();
        contentVBox.setPadding(new Insets(10));
        contentVBox.setSpacing(10);

        Label welcomeLabel = new Label("Welcome to Library Management System");
        welcomeLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        contentVBox.getChildren().add(welcomeLabel);

        // Set up the BorderPane layout
        borderPane.setTop(menuBar);
        borderPane.setLeft(navigationVBox);
        borderPane.setCenter(contentVBox);

        Scene scene = new Scene(borderPane, 800, 600);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void showAddBookForm() {
        // Add logic to show the Add Book form
        System.out.println("Showing Add Book Form");
    }

    private void showIssueBookForm() {
        // Add logic to show the Issue Book form
        System.out.println("Showing Issue Book Form");
    }

    private void showReturnBookForm() {
        // Add logic to show the Return Book form
        System.out.println("Showing Return Book Form");
    }

    private void showViewBooksTable() {
        // Add logic to show the View Books table
        System.out.println("Showing View Books Table");
    }
}
