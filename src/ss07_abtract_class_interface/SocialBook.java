package ss07_abtract_class_interface;

public class SocialBook extends Book implements IBook {
    private String author;

    public SocialBook() {
    }

    public String display() {
        return "SocialBook{" +
                "nameBook='" + getNameBook() + '\'' +
                ", copyright='" + getCopyright() + '\'' +
                ", dateCopyright='" + getDateCopyright() + '\'' +
                "author='" + author + '\'' +
                '}';
    }

    public SocialBook(String nameBook, String copyright, String dateCopyright, String author) {
        super(nameBook, copyright, dateCopyright);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
