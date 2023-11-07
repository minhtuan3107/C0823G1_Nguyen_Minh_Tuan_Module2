package Furama.models;

public class Promotion {
    private int count;
    private String voucher;

    @Override
    public String toString() {
        return "Promotion{" +
                "count=" + count +
                ", voucher='" + voucher + '\'' +
                '}';
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getVoucher() {
        return voucher;
    }

    public void setVoucher(String voucher) {
        this.voucher = voucher;
    }

    public Promotion(int count, String voucher) {
        this.count = count;
        this.voucher = voucher;
    }
}
