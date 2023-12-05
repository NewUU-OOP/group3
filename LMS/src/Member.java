import java.util.Date;

public class Member extends Account {

    private Date dateOfMembership;
    private int totalBooksCheckedout;

    public int getTotalBooksCheckedout() {
        return 0;
    }

    public boolean reserveBookItem(BookItem bookItem) {
        return true;
    }

    private void incrementTotalBooksCheckedout() {
    }

    public boolean checkoutBookItem(BookItem bookItem) {

        return true;
    }

    private void checkForFine(String bookItemBarcode) {

    }

    public void returnBookItem(BookItem bookItem) {


    }

    public boolean renewBookItem(BookItem bookItem) {


        return true;
    }
}
