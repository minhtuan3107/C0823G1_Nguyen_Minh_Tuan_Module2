package Furama.utils;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    private final Scanner scanner = new Scanner(System.in);

    public String checkEmpty() {
        String str;
        do {
            str = scanner.nextLine();
            if (!(str.isEmpty())) {
                return str;
            } else {
                System.out.println("Vui lòng nhập không để rỗng");
            }
        } while (true);
    }

    public String checkEmail() {
        String email;
        String regexEmail = "^[A-Za-z1-9]{5,16}@[a-z1-9]{3,10}.[a-z]{2,6}$";
        do {
            email = checkEmpty();
            if (patternMatches(email, regexEmail)) {
                return email;
            } else {
                System.out.println("Vui lòng nhập đúng định dạng email");
            }
        } while (true);
    }



    public boolean patternMatches(String check, String regex) {
        return Pattern.compile(regex).matcher(check).matches();
    }

    public int idNumber() {
        String idNumberCheck;
        String regexNummber = "^[0-9]{9,12}$";
        do {
            idNumberCheck = checkEmpty();
            if (patternMatches(idNumberCheck, regexNummber)) {
                return Integer.parseInt(idNumberCheck);
            } else {
                System.out.println("Vui lòng nhập đúng định dạng 9 - 12 số");
            }
        } while (true);
    }

    public String choiceGender() {
        int choice;
        do {
            try {
                System.out.println("1. Nam");
                System.out.println("2. Nữ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return "Nam";
                    case 2:
                        return "Nữ";
                    default:
                        System.out.println("Nam hoặc Nữ");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập số");
            }
        } while (true);
    }

    public String checkBirthday() {
        String birthday;
        do {
            try {
                birthday = checkEmpty();
                if (checkBirthday(birthday)) {
                    return birthday;
                } else {
                    System.out.println("Vui lòng nhập lại");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Vui lòng nhập đúng định dạng ngày tháng năm");
            }
        } while (true);
    }

    public boolean checkBirthday(String birthday) {
        LocalDate birthDate = LocalDate.parse(birthday, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthDate, currentDate);
        return period.getYears() >= 18;
    }

    public String checkName() {
        String nameCheck;
        String regexName = "^[A-Z]{1}[a-z]{1,6}$";
        String[] arr;
        int count;
        do {
            nameCheck = checkEmpty();
            count = 0;
            arr = nameCheck.split(" ");
            for (String s : arr) {
                if (patternMatches(s, regexName)) {
                    count++;
                }
            }
            if (count == arr.length && arr.length >= 2 && arr.length <= 5) {
                return nameCheck;
            } else {
                System.out.println("Vui lòng nhập lại họ và tên");
            }
        } while (true);
    }


    public int checkPhone() {
        String phone;
        String regexPhone = "^0[3|5|7|8|9]{1}[0-9]{8}$"; // ^84\+[3|5|7|9]{1}[1-9]{8}$
        do {
            phone = checkEmpty();
            if (patternMatches(phone, regexPhone)) {
                return Integer.parseInt(phone);
            } else {
                System.out.println("Vui lòng nhập đúng định dạng sdt");
            }
        } while (true);
    }

}
