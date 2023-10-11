package ss07_abtract_class_interface;

public class NaturalBook extends Book implements IBook {
    private String outputQuantity;

    public NaturalBook() {
    }

    public NaturalBook(String nameBook, String copyright, String dateCopyright, String outputQuantity) {
        super(nameBook, copyright, dateCopyright);
        this.outputQuantity = outputQuantity;
    }

    public String getOutputQuantity() {
        return outputQuantity;
    }

    public void setOutputQuantity(String outputQuantity) {
        this.outputQuantity = outputQuantity;
    }

    public String display() {
        return "NaturalBook{" +
                "nameBook='" + getNameBook() + '\'' +
                ", copyright='" + getCopyright() + '\'' +
                ", dateCopyright='" + getDateCopyright() + '\'' +
                "outputQuantity='" + outputQuantity + '\'' +
                '}';
    }
}
