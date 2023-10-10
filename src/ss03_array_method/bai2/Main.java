package ss03_array_method.bai2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số lượng phần tử trong mảng");
        int length = scanner.nextInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            System.out.println("Nhập phần tử thứ: " + (i));
            array[i] = scanner.nextInt();
        }
        int count = 0;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (i % 2 != 0) {
                sum += array[i];
                count++;
            }
        }
        System.out.println("Trung bình cộng các số nguyên ở vị trí lẻ là: " + (sum / count));
    }
}
