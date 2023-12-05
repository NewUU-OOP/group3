import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Library Management System");
        Address address = new Address("Movarounnahr 1","Tashkent","Tashkent","1001100","Uzbekistan");

        Library library = new Library(address);

    }
}