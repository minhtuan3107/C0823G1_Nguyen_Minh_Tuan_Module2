package ss12_javacollection_framework.model;

public class Fruit {
        private String nameFruit;
        private String typeFruit;
        private String date;
        private String expiry;
        private String origin;
        private int price;

        @Override
        public String toString() {
            return "Fruit{" +
                    "nameFruit='" + nameFruit + '\'' +
                    ", typeFruit='" + typeFruit + '\'' +
                    ", date='" + date + '\'' +
                    ", expiry='" + expiry + '\'' +
                    ", origin='" + origin + '\'' +
                    ", price=" + price +
                    '}';
        }

        public Fruit() {
        }

        public Fruit(String nameFruit, String typeFruit, String date, String expiry, String origin, int price) {
            this.nameFruit = nameFruit;
            this.typeFruit = typeFruit;
            this.date = date;
            this.expiry = expiry;
            this.origin = origin;
            this.price = price;
        }

        public String getNameFruit() {
            return nameFruit;
        }

        public void setNameFruit(String nameFruit) {
            this.nameFruit = nameFruit;
        }

        public String getTypeFruit() {
            return typeFruit;
        }

        public void setTypeFruit(String typeFruit) {
            this.typeFruit = typeFruit;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getExpiry() {
            return expiry;
        }

        public void setExpiry(String expiry) {
            this.expiry = expiry;
        }

        public String getOrigin() {
            return origin;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }
    }

