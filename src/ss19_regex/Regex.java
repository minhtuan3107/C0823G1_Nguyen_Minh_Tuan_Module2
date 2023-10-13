package ss19_regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Regex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Mời nhập email để check");
        String email = scanner.nextLine();
        String regexEmail = "^[\\w-\\.]+[0-9]+@(gmail\\.)+[\\w-]{3}$";
        System.out.println("Email: " + email + " " + patternMatches(email, regexEmail));
    }

    public static boolean patternMatches(String emailAddress, String regexPattern) {
        return Pattern.compile(regexPattern)
                .matcher(emailAddress)
                .matches();
    }
}
