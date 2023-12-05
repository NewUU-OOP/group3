import java.util.List;

public class Author {
    private String name;
    private String description;
    private List<Book> bookList;
    public void addBook(Book book){
        bookList.add(book);
    }


    public Author(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
