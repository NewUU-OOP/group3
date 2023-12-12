package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class BookSearch extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GridPane gridPane=new GridPane();
        gridPane.setPadding(new Insets(10,10,10,10));


        Label label1=new Label("tittle");
        Label label2=new Label("Author");
        Label label3=new Label("Number of Books");
        Label label4=new Label("ISBN");
        Label label5=new Label("ID");

        TextField tittle=new TextField();
        TextField Author=new TextField();
        TextField Books=new TextField();
        TextField ISBN=new TextField();
        TextField ID=new TextField();


        stage.setTitle("Application");

        gridPane.add(label1,0,0);
        gridPane.add(tittle,1,0);
        gridPane.add(label2,0,1);
        gridPane.add(Author,1,1);
        gridPane.add(label3,0,2);
        gridPane.add(Books,1,2);
        gridPane.add(label4,0,3);
        gridPane.add(ISBN,1,3);
        gridPane.add(label5,0,4);
        gridPane.add(ID,1,4);

        gridPane.setHgap(50);
        gridPane.setVgap(50);

        Scene scene=new Scene(gridPane,400,400);
        stage.setScene(scene);


        stage.show();

    }
}
