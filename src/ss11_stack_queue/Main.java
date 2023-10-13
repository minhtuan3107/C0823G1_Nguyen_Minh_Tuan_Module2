package ss11_stack_queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Nhập n số: ");
        n = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                stack.push(i);
            }
        }
        System.out.println("Các số nguyên tố bé hơn " + n + "  sau khi được đưa vào stack:");
        for (int number : stack) {
            System.out.println(number);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) {
                queue.offer(i);
            }
        }
        System.out.println("Các số nguyên tố bé hơn " + n + " sau khi được đưa vào queue:");
        for (int number : queue) {
            System.out.println(number);
        }
    }

    public static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
