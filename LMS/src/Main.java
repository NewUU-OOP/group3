import javax.sound.midi.Soundbank;

public class Main {
    public static void main(String[] args) {

        System.out.println("Welcome to Library Management System");
        Address address = new Address("Movarounnahr 1","Tashkent","Tashkent","1001100","Uzbekistan");
        Library library = new Library(address);
        library.setName("New Uzbekistan Library ");
        Author author1 = new  Author("Chingiz Aytmatov","Chingiz Aytmatov was born Kirgizistan. He wrote book about White Ship, Jamila");
        Author author2 = new Author("George Orwell","Animal Farm");


        System.out.println(library.toString());

    }
}