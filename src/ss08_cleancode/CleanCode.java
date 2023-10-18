package ss08_cleancode;

public class CleanCode {
    public int total(int number1, int number2, int number3) {
        int total = number1 + number2 + number3;
        return total;
    }

    private void employeeDetails(Employee employee) {
        // Do something
    }

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    public String getDayOfMonth(int month, int year) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return "Tháng " + month + " có 31 ngày ";
            case 4:
            case 11:
            case 6:
            case 9:
                return "Tháng " + month + " có 30 ngày ";
            case 2:
                if (isLeapYear(year)) {
                    return "Tháng 2 năm nhuận có 29 ngày";
                } else {
                    return "Tháng 2 năm nhuận có 30 ngày";
                }
            default:
                return "Vui lòng nhập từ tháng 1 - tháng 12";
        }
    }
}
