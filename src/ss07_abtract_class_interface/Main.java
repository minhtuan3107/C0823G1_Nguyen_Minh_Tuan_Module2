package ss07_abtract_class_interface;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Doraemon", "Shogakukan", "2023");
        System.out.println(book.display());
        NaturalBook naturalBook = new NaturalBook("Conan", "Aoyama", "2023", "2000");
        System.out.println(naturalBook.display());
        SocialBook socialBook = new SocialBook("Shin", "Crayon Shin-chan", "2020", "Usui Yoshito");
        System.out.println(socialBook.display());
    }
}
