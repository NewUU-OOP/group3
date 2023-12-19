import java.util.List;

public abstract class Book {

    private String ISBN;
    private String title;
    private String subject;
    private String publisher;
    private String language;
    private int numberOfPages;
    private List<Author> authors;

    public Book(String isbn, String title, String subject, String publisher, String language, int numberOfPages, List<Author> authors) {

    }
}
