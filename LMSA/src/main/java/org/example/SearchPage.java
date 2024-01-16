package org.example;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class SearchPage extends Application implements Search{

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainContainer = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu createAccount = new Menu("Account");
        Menu books  = new Menu("Books");
        MenuItem addBooks = new MenuItem("Add/Update books");
        MenuItem deleteBooks = new MenuItem("Delete Books");
        MenuItem addAccount = new MenuItem("Add Account");
        MenuItem deleteAccount = new MenuItem("Delete Account");
        MenuItem updateAccount = new MenuItem("Update Account");
        createAccount.getItems().addAll(addAccount,deleteAccount,updateAccount);

        books.getItems().add(0,addBooks);
        books.getItems().add(1,deleteBooks);

        Menu loginSystem = new Menu("Login");
        menuBar.getMenus().addAll(loginSystem,createAccount,books);
        mainContainer.setTop(menuBar);
        primaryStage.setTitle("Search Page");
        VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setPadding(new Insets(20));
        vbox.setAlignment(Pos.CENTER_LEFT);
        // Search Label
        Label searchLabel = new Label("Search:");
        searchLabel.setAlignment(Pos.CENTER);
        searchLabel.setStyle("-fx-font-size: 28px; -fx-font-weight: bold;-fx-font-family: 'Times New Roman'");

        Label loginInfo = new Label("");

        loginSystem.setOnAction(actionEvent -> {
            System.out.println("Login view ");
        });
        addBooks.setOnAction(actionEvent -> {
           BookForm bookForm = new BookForm();
           bookForm.showBookInfo("");
        });

        addAccount.setOnAction(actionEvent -> {
            PersonDetailsForm personDetailsForm = new PersonDetailsForm();
            personDetailsForm.start(new Stage());

        });

        // Search Text Input
        TextField searchTextField = new TextField();
        searchTextField.setPromptText("Search by: Title, Author, ISBN, Genre");

        // Search Button
        Button searchButton = new Button("Search");
        searchButton.setStyle("-fx-font-size: 14px;");



        TableView<Book> tableView = new TableView<>();

        tableView.setOnMouseClicked(mouseEvent -> getIndexTableView(tableView));

        TableColumn<Book, String> ISBNCol = createColumn("ISBN", "ISBN");
        TableColumn<Book, String> titleCol = createColumn("Title", "title");
        TableColumn<Book, String> subjectCol = createColumn("Subject", "subject");
        TableColumn<Book, String> publisherCol = createColumn("Publisher", "publisher");
        TableColumn<Book, String> languageCol = createColumn("Language", "language");
        TableColumn<Book, Integer> pagesCol = createColumn("Pages", "pages");

        tableView.setItems(getSampleBookData(searchTextField.getText()));

        tableView.getColumns().addAll(ISBNCol, titleCol, subjectCol, publisherCol,
                        languageCol, pagesCol);
        // Create context menu items
        MenuItem reserveItem = new MenuItem("Reserve");
        MenuItem viewItem = new MenuItem("View");

        searchTextField.setOnAction(actionEvent -> {
            tableView.setItems(getSampleBookData(searchTextField.getText()));
        });

        // Event handler for the search button (replace with your search logic)
        searchButton.setOnAction(event -> {
            tableView.setItems(getSampleBookData(searchTextField.getText()));
                }
        );

        // Set actions for context menu items
        reserveItem.setOnAction(event -> reserveSelectedBook(tableView.getSelectionModel().getSelectedItem(),primaryStage));
        viewItem.setOnAction(event -> viewSelectedBook(tableView.getSelectionModel().getSelectedItem()));

        // Create context menu and add items
        ContextMenu contextMenu = new ContextMenu();
        contextMenu.getItems().addAll(reserveItem, viewItem);

        // Set context menu for the TableView
        tableView.setContextMenu(contextMenu);
       // Add components to the VBox
        vbox.getChildren().addAll(searchLabel, searchTextField, searchButton);
        VBox containerSearchAndTableView = new VBox();
        containerSearchAndTableView.getChildren().addAll(vbox,tableView);

        //mainContainer.setTop(vbox);
        mainContainer.setCenter(containerSearchAndTableView);

        // Set up the scene
        Scene scene = new Scene(mainContainer);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1050);
        primaryStage.setMinHeight(700);
        primaryStage.show();
    }
    private <S, T> TableColumn<Book, T> createColumn(String columnName, String propertyName) {
        TableColumn<Book, T> column = new TableColumn<>(columnName);
        column.setCellValueFactory(cellData -> getProperty(cellData, propertyName));
        return column;
    }
    private <S, T> javafx.beans.value.ObservableValue<T> getProperty(TableColumn.CellDataFeatures<Book, T> cellData, String propertyName) {
        try {
            java.lang.reflect.Field field = Book.class.getDeclaredField(propertyName);
            field.setAccessible(true);
            return new javafx.beans.property.SimpleObjectProperty<>((T) field.get(cellData.getValue()));
        } catch (Exception e) {
            throw new RuntimeException("Error getting property " + propertyName, e);
        }
    }
    public void getIndexTableView(TableView<Book> tableView){
        String name = tableView.getSelectionModel().getSelectedItem().getISBN();
        System.out.println(name);
    }
    private void reserveSelectedBook(Book selectedBook, Stage primaryStage) {
        if (selectedBook != null) {
            // Implement your reserve logic here

            System.out.println("Book Reserved: " + selectedBook.getTitle());
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(primaryStage);
            LoginPasswordForm loginPasswordForm = new LoginPasswordForm();
            loginPasswordForm.start(stage);
        }
    }

    private void viewSelectedBook(Book selectedBook) {
        if (selectedBook != null) {
            BookForm bookForm = new BookForm();
            bookForm.showBookInfo(selectedBook.getISBN());
            System.out.println("Viewing Book: " + selectedBook.getISBN());
        }
    }
    private ObservableList<Book> getSampleBookData(String text) {

        System.out.println("Hello from Search");
        ObservableList<Book> newData =FXCollections.observableArrayList();

        try {
            ResultSet resultSet = DatabaseConnection.getData("SELECT * FROM bookinfo WHERE title LIKE '%"+text+"%' " +
                    "|| subject LIKE '%"+text+"%' || isbn LIKE '%"+text+"%'");
            if (resultSet != null) {
                while (resultSet.next()) {
                    newData.add(new Book(
                            resultSet.getString(1),
                            resultSet.getString(2),
                            resultSet.getString(3),
                            resultSet.getString(4),
                            resultSet.getString(5),
                            resultSet.getInt(6)));
                }
            }
        } catch(SQLException e){
            throw new RuntimeException(e);
        }

       return newData;
    }

    @Override
    public List<Book> searchByTitle(String title) {
        return null;
    }

    @Override
    public List<Book> searchByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> searchBySubject(String subject) {
        return null;
    }

    @Override
    public List<Book> searchByPubDate(Date publishDate) {
        return null;
    }

}
