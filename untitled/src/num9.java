import java.util.Scanner;

public class num9 {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
        Scanner sc = new Scanner(System.in);
        String date;
        boolean flag;
        int day, month, year;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            date = sc.nextLine();//строчка
            if (date.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }

            if (Utils.emptyStr(date)) {
                System.out.println("Строчка пуста!");
                continue;
            }

            if (date.length() != 10 || date.indexOf('.') != 2 || date.lastIndexOf('.') != 5) {
                System.out.println("Ошибка: неверный формат даты!");
                continue;
            }

            day = convertEnteredNumber(date.substring(0, 2));
            month = convertEnteredNumber(date.substring(3, 5));
            year = convertEnteredNumber(date.substring(6));
            flag = true;
            if ((day > 31) || checkMonthDay(month, year) < day) {//проверка даты и.т.д
                flag = false;
                System.out.println("Ошибка: некорректная дата - \"" + date.substring(0, 2) + "\" !");
            } else if (month > 12 || month < 1) {
                flag = false;
                System.out.println("Ошибка: некорректный месяц - \"" + date.substring(3, 5) + "\" !");
            } else if (year < 1000 || year > 9999) {
                flag = false;
                System.out.println("Ошибка: некорректный год - \"" + date.substring(6) + "\" !");
            }
            if (flag)
                System.out.println(date.substring(0, 2) + "\n" + date.substring(3, 5) + "\n" + date.substring(6));
    }

}

    private static int convertEnteredNumber(String nums)//конвертирую из строки в число
    {
        int num = 0;
        for (int i = nums.length() - 1; i >= 0; i--)
            num += (nums.charAt(i) - 48) * ((int) Math.pow(10, (nums.length() - 1) - i));
        return num;
    }

    private static int checkMonthDay(int month, int year) {//Проверяю кол-во дней
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                return year % 400 == 0 || year % 4 == 0 && year % 100 != 0 ? 29 : 28;
            default:
                return 0;
        }
    }
}
