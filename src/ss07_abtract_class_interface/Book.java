package ss07_abtract_class_interface;

public class Book implements IBook {
    private String nameBook;
    private String copyright;
    private String dateCopyright;

    public String display() {
        return "Book{" +
                "nameBook='" + nameBook + '\'' +
                ", copyright='" + copyright + '\'' +
                ", dateCopyright='" + dateCopyright + '\'' +
                '}';
    }

    public Book() {
    }

    public Book(String nameBook, String copyright, String dateCopyright) {
        this.nameBook = nameBook;
        this.copyright = copyright;
        this.dateCopyright = dateCopyright;
    }

    public String getNameBook() {
        return nameBook;
    }

    public void setNameBook(String nameBook) {
        this.nameBook = nameBook;
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
    }

    public String getDateCopyright() {
        return dateCopyright;
    }

    public void setDateCopyright(String dateCopyright) {
        this.dateCopyright = dateCopyright;
    }
}
