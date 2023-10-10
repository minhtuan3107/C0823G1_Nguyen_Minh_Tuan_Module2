package ss01_introduction_to_java;

import java.util.Scanner;

public class Main {
    public static double add(double a, double b) {
        return a + b;
    }

    public static double apartFrom(double a, double b) {
        return a - b;
    }

    public static double core(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) {
        return a / b;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất");
        double a = scanner.nextDouble();
        System.out.println("Nhập số thứ hai");
        double b = scanner.nextDouble();
        int choice;
        try {
            System.out.println("1. Cộng");
            System.out.println("2. Trừ");
            System.out.println("3. Nhân");
            System.out.println("4. Chia");
            System.out.println("5. Thoát");
            System.out.println("Mời chọn");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Kết quả: " + add(a, b));
                    break;
                case 2:
                    System.out.println("Kết quả: " + apartFrom(a, b));
                    break;
                case 3:
                    System.out.println("Kết quả: " + core(a, b));
                    break;
                case 4:
                    System.out.println("Kết quả: " + divide(a, b));
                    break;
                default:
                    System.out.println("Chọn từ 1 - 4");

            }
        } catch (NumberFormatException e) {
            System.out.println("Vui lòng nhập số");
        }
    }
}
