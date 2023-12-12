import java.util.Date;
import java.util.List;

public class BookItem extends Book {

    private String barcode;
    private boolean isReferenceOnly;
    private Date borrowed;
    private Date dueDate;
    private double price;
    private BookFormat format;
    private BookStatus status;
    private Date dateOfPurchase;
    private Date publicationDate;
    private Rack placedAt;

    public BookItem(String ISBN, String title, String subject, String publisher, String language, int numberOfPages, List<Author> authors) {
        super(ISBN, title, subject, publisher, language, numberOfPages, authors);
    }

    public boolean checkout(String memberId) {

        return true;
    }

}
