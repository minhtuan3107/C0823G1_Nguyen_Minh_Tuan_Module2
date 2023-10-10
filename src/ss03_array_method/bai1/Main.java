package ss03_array_method.bai1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] a = {1, 2, 3, 4, 5, 1, 2};
        System.out.println("Nhập số cần tìm");
        int number = scanner.nextInt();
        int index = 0;
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] == number) {
                index = i;
                count++;
            }
        }
        if (count > 0) {
            System.out.println("Số bạn tìm là : " + number + " nằm ở vị trí: " + index);
        } else {
            System.out.println("Không tồn tại");
        }
    }
}
