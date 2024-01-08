package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BookForm {

    public void showBookInfo(String isbn){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Book Information Form");
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding( new Insets(10,10,10,10));

        // ISBN
        grid.add(new Label("ISBN:"), 0, 0);
        TextField isbnField = new TextField();
        isbnField.setText(isbn);
        grid.add(isbnField, 1, 0);

        // Title
        grid.add(new Label("Title:"), 0, 1);
        TextField titleField = new TextField();
        grid.add(titleField, 1, 1);

        // Subject
        grid.add(new Label("Subject:"), 0, 2);
        TextField subjectField = new TextField();
        grid.add(subjectField, 1, 2);

        // Publisher
        grid.add(new Label("Publisher:"), 0, 3);
        TextField publisherField = new TextField();
        grid.add(publisherField, 1, 3);

        // Language
        grid.add(new Label("Language:"), 0, 4);
        TextField languageField = new TextField();
        ;languageField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                // If the entered text contains non-numeric characters, replace it with an empty string
                languageField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(languageField, 1, 4);

        // Number of Pages
        grid.add(new Label("Number of Pages: *"), 0, 5);
        TextField pagesField = new TextField();
        pagesField.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d*")) {
                // If the entered text contains non-numeric characters, replace it with an empty string
                pagesField.setText(newValue.replaceAll("[^\\d]", ""));
            }
        });
        grid.add(pagesField, 1, 5);

        // Buttons
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            // Handle save action

                try {
                    if (DatabaseConnection.getData("SELECT * FROM bookinfo WHERE isbn ="+isbnField.getText()+"").next())
                    {
                        System.out.println("System updating existing book info");
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirmation");
                        alert.setHeaderText("Book already exist in the database");
                        alert.setContentText("Do you want to update the existing book?");
                        alert.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                // User clicked OK, proceed with the update
                                try {
                                    DatabaseConnection.saveData("UPDATE bookinfo " +
                                            " SET title = '" + titleField.getText() +
                                            "', subject = '" + subjectField.getText() + "', publisher = '" + publisherField.getText() + "', language = '" + languageField.getText() + "', " +
                                            " pages = '" + pagesField.getText() + "' WHERE isbn = '" + isbnField.getText() + "'");
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }

                                System.out.println("Book details updated successfully.");
                                isbnField.clear();
                                titleField.clear();
                                subjectField.clear();
                                publisherField.clear();
                                languageField.clear();
                                pagesField.clear();


                            } else {
                                // User clicked Cancel or closed the dialog, handle accordingly
                                System.out.println("Update canceled or dialog closed.");
                            }
                        });

                        }
                    else {
                        if (!titleField.getText().isEmpty() && !subjectField.getText().isEmpty()&&
                        !publisherField.getText().isEmpty()&&!languageField.getText().isEmpty()&&!pagesField.getText().isEmpty()) {
                            DatabaseConnection.saveData("INSERT INTO bookinfo (isbn, title, subject, publisher, language, pages)" +
                                    "VALUES ('"+isbnField.getText()+"', '"+titleField.getText()+"','"+subjectField.getText()+"'," +
                                    "'"+publisherField.getText()+"','"+languageField.getText()+"','"+pagesField.getText()+"')");
                        }else {
                            Alert alert = new Alert(Alert.AlertType.ERROR, "Please fill in all data fields.");
                            alert.setTitle("Error");
                            alert.show();
                        }
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }



        });




        Button cancelButton = new Button("Cancel");
        cancelButton.setOnAction(e -> {
            // Handle cancel action

            System.out.println("Closing form");
            primaryStage.close();
        });
        isbnField.setOnAction(actionEvent -> {
            try {
                ResultSet resultSet = DatabaseConnection.getData("SELECT * FROM bookinfo WHERE isbn ="+isbnField.getText()+"");
                if (resultSet.next()){
                    titleField.setText(resultSet.getString(2));
                    subjectField.setText(resultSet.getString(3));
                    publisherField.setText(resultSet.getString(4));
                    languageField.setText(resultSet.getString(5));
                    pagesField.setText(resultSet.getString(6));
                }
                else {
                    titleField.setText("");
                    subjectField.setText("");
                    publisherField.setText("");
                    languageField.setText("");
                    pagesField.setText("");
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Get Book Info");
        });
        grid.add(saveButton, 0, 6);
        grid.add(cancelButton, 1, 6);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }




    private void saveData(String isbn) throws SQLException {
         // Implement save logic here



        System.out.println("Saving data to DB");
    }

    private void updateData() {
        // Implement update logic here
        // Retrieve data from text fields and perform necessary actions
    }


}
