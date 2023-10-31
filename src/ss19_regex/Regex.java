package ss19_regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email;
        String regexEmail;
        do {
            System.out.println("Nhập email để kiểm tra");
            email = scanner.nextLine();
            regexEmail = "^[A-Za-z1-9]{6,32}@[a-z]{2,12}\\.[a-z]{2,12}$";
            System.out.println("Email: " + email + " " + patternMatches(email, regexEmail));
        } while (true);
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern).matcher(emailAddress).matches();
    }
}
