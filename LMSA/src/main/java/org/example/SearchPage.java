package org.example;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class SearchPage extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane mainContainer = new BorderPane();
        MenuBar menuBar = new MenuBar();
        Menu createAccount = new Menu("Create Account");
        Menu addBooks  = new Menu("Add/Update");
        menuBar.getMenus().addAll(createAccount,addBooks);
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
        TableColumn<Book, String> authorCol = createColumn("Author", "author");
        TableColumn<Book, Rack> placedAtCol = createColumn("Placed At", "placedAt");
        TableColumn<Book, BookFormat> formatCol = createColumn("Format", "format");
        TableColumn<Book, BookStatus> statusCol = createColumn("Status", "status");
        tableView.setItems(getSampleBookData());

        tableView.getColumns().addAll(ISBNCol, titleCol, subjectCol, publisherCol,
                        languageCol, authorCol, placedAtCol, formatCol, statusCol);
        // Create context menu items
        MenuItem reserveItem = new MenuItem("Reserve");
        MenuItem viewItem = new MenuItem("View");

        // Event handler for the search button (replace with your search logic)
        searchButton.setOnAction(event -> {
            if (!searchTextField.getText().isEmpty()) {
                String searchText = searchTextField.getText();
                System.out.println("Searching for: " + searchText);
                // Add your search logic here
                int size = tableView.getItems().size();
                ObservableList<Book> newData = FXCollections.observableArrayList();
                while (size > 0) {
                    if (tableView.getItems().get(size-1).getAuthor().contains(searchText)) {
                        System.out.println("Found");
                        newData.add(tableView.getItems().get(size - 1));
                    }
                    size--;
                }
                tableView.setItems(newData);
            }else {
                tableView.setItems(getSampleBookData());
            }



        });

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
        HBox hBox = new HBox();
        hBox.getChildren().addAll(vbox,tableView);
        //mainContainer.setTop(vbox);
        mainContainer.setCenter(hBox);

        // Set up the scene
        Scene scene = new Scene(mainContainer);
        primaryStage.setScene(scene);
        primaryStage.setMinWidth(1050);
        primaryStage.setMinHeight(700);
        primaryStage.setFullScreen(true);


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
            // Implement your view logic here
            System.out.println("Viewing Book: " + selectedBook.getTitle());
        }
    }
    private ObservableList<Book> getSampleBookData() {
        ObservableList<Book> data = FXCollections.observableArrayList();
        data.add(new Book("1234567890", "The Great Gatsby", "Fiction", "Scribner", "English", "F. Scott Fitzgerald", new Rack(1,"A"), BookFormat.HARDCOVER, BookStatus.AVAILABLE));
        data.add(new Book("2345678901", "To Kill a Mockingbird", "Mystery", "J.B. Lippincott & Co.", "English", "Harper Lee", new Rack(2,"A"), BookFormat.PAPERBACK, BookStatus.RESERVED));
        data.add(new Book("3456789012", "A Brief History of Time", "Science", "Bantam Books", "English", "Stephen Hawking", new Rack(3,"B"), BookFormat.EBOOK, BookStatus.AVAILABLE));
        data.add(new Book("4567890123", "Pride and Prejudice", "Romance", "T. Egerton, Whitehall", "English", "Jane Austen", new Rack(3,"B"), BookFormat.HARDCOVER, BookStatus.AVAILABLE));
        data.add(new Book("5678901234", "The Da Vinci Code", "History", "Doubleday", "English", "Dan Brown", new Rack(3,"B"), BookFormat.PAPERBACK, BookStatus.AVAILABLE));
        data.add(new Book("6789012345", "Harry Potter and the Philosopher's Stone", "Fantasy", "Bloomsbury", "English", "J.K. Rowling", new Rack(3,"B"), BookFormat.EBOOK, BookStatus.RESERVED));
        data.add(new Book("7890123456", "The Girl with the Dragon Tattoo", "Thriller", "Norstedts Förlag", "Swedish", "Stieg Larsson", new Rack(3,"B"), BookFormat.HARDCOVER, BookStatus.LOANED));

        return data;
    }

}
