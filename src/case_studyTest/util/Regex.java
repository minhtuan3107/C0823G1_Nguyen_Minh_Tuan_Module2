package case_studyTest.util;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    private static final String ID_EMPLOYEE_REGEX = "^NV-[0-9]{4}$";
    private static final String NAME_REGEX = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    private static final String DOB_REGEX = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/\\d{4}$";
    private static final String GENDER_REGEX = "^(Male|Female|male|female)$";
    private static final String ID_CARD_REGEX = "^\\d{9}(\\d{3})?$";
    private static final String PHONE_NUMBER_REGEX = "^0\\d{9}$";
    private static final String EMAIL_REGEX ="[^@]{2,64}@[^.]{2,253}\\.[0-9a-z-.]{2,63}";
    private static final String SALARY_REGEX = "^[1-9]\\d*$";
    private static final String ID_CUSTOMER_REGEX = "^KH-[0-9]{4}$";
    private static final String CODE = "^[0-9]{4}$";

    public static boolean idEmployeeValidate(String regex) {
        Pattern pattern = Pattern.compile(ID_EMPLOYEE_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean nameValidate(String regex) {
        Pattern pattern = Pattern.compile(NAME_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean is18YearsOld(String dayOfBirth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthDate = LocalDate.parse(dayOfBirth, formatter);
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears() >= 18;
    }
    public static boolean genderValidate(String regex){
        Pattern pattern = Pattern.compile(GENDER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean idCardValidate(String regex){
        Pattern pattern = Pattern.compile(ID_CARD_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean phoneNumberValidate(String regex){
        Pattern pattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean emailValidate(String regex){
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean salaryValidate(String regex){
        Pattern pattern = Pattern.compile(SALARY_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean dOBValidate(String regex){
        Pattern pattern = Pattern.compile(DOB_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean idCustomerValidate(String regex) {
        Pattern pattern = Pattern.compile(ID_CUSTOMER_REGEX);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
    public static boolean codeValidate(String regex) {
        Pattern pattern = Pattern.compile(CODE);
        Matcher matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
