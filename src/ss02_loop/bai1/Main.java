package ss02_loop.bai1;

import java.util.Scanner;

public class Main {
    public static int checkNumber(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số");
        int number = scanner.nextInt();
        System.out.println("Tổng các ước là: " + checkNumber(number));
    }
}
