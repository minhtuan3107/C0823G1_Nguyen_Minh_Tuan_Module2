package ss02_loop.bai2;

import java.util.Scanner;

public class Main {
    public static int findMaximumJointEstimate(int a, int b) {
        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }

    public static int findLeastCommonMultiple(int a, int b) {
        return a * b / findMaximumJointEstimate(a, b);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số thứ nhất");
        int a = scanner.nextInt();
        System.out.println("Nhập số thứ hai");
        int b = scanner.nextInt();
        int gcd = findMaximumJointEstimate(a, b);
        int lcm = findLeastCommonMultiple(a, b);
        double average = (gcd + lcm) / 2.0;
        System.out.println("Giá trị trung bình của GCD và LCM " + a + " và " + b + " là: " + average);

    }
}
