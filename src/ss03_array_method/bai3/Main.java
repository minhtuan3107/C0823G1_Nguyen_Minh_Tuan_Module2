package ss03_array_method.bai3;

import java.util.Scanner;

public class Main {
    public static int checkNumber(int[][] array2d) {
        int count = 0;
        int sum = 0;
        for (int i = 0; i < array2d.length; i++) {
            for (int j = 0; j < array2d[i].length; j++) {
                if (array2d[i][j] % 2 == 0) {
                    count++;
                    sum += array2d[i][j];
                }
            }
        }
        return sum / count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số hàng");
        int row = scanner.nextInt();
        System.out.println("Nhập số cột");
        int col = scanner.nextInt();
        int[][] array2d = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.println("Nhập phần tử thứ " + i + " " + j);
                array2d[i][j] = scanner.nextInt();
            }
        }
        System.out.println("Trung bình cộng các số chẵn trong mảng là: " + checkNumber(array2d));
    }
}
