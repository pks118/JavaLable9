import java.util.Scanner;

public class num9 {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
        Scanner sc = new Scanner(System.in);
        String date;
        String error = "";
        boolean flag = true;
        int stage = 0;
        boolean strTrue;
        int day, month, year;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            date = sc.nextLine();//строчка
            if (date.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            strTrue = date.length() > 0;
            if (strTrue) {//проверяю синтаксис
                for (int i = 0; i < date.length(); i++) {
                    if ((!(date.charAt(i) >= '0' && date.charAt(i) <= '9')) && date.charAt(i) != '.') {
                        error = "Ошибка: \"" + date.charAt(i) + "\" не допустимый формат!";
                        flag = false;
                        break;
                    } else if ((date.charAt(i) == '.')) {
                        if (i != 2 && stage == 0) {//проверяю стоит ли точка на своём месте
                            error = "Ошибка: день \"" + date.substring(0, i) + "\" введён не корректно!";
                            flag = false;
                            break;
                        } else if (i != 5 && stage == 1) {
                            error = "Ошибка: месяц \"" + date.substring(3, i) + "\" введён не корректно!";
                            flag = false;
                            break;
                        }
                        stage++;
                    }
                }
                if (stage != 2) {
                    error = "Ошибка: некорректное количество точек!";
                    flag = false;
                }
                stage = 0;
                if (flag) {//проверяю валидацию
                    day = convertEnteredNumber(date.substring(0, 2));
                    month = convertEnteredNumber(date.substring(3, 5));
                    year = convertEnteredNumber(date.substring(6));
                    if (date.length() > 10) {//проверяю на наличие ошибки и вышел ли пользователь за допустимый формат
                        flag = false;
                        error = "Ошибка: вы вышли за границы формата!";
                    } else if ((day > 31) || checkMonthDay(month) < day) {//проверка даты и.т.д
                        flag = false;
                        error = "Ошибка: некорректная дата: \"" + date.substring(0, 2) + "\" !";
                    } else if (month > 12 || month < 1) {
                        flag = false;
                        error = "Ошибка: некорректный месяц: \"" + date.substring(3, 5) + "\" !";
                    } else if (year < 1925 || year > 2025) {
                        flag = false;
                        error = "Ошибка: некорректный год: \"" + date.substring(6) + "\" !";
                    }
                }
                if(flag)
                    System.out.println(date.substring(0, 2) + "\n" + date.substring(3, 5) + "\n" + date.substring(6));
                else {
                    System.out.println(error);
                    flag = true;
                }
            }
        }
    }

    private static int convertEnteredNumber(String nums)//конвертирую из строки в число
    {
        int num = 0;
        for (int i = nums.length() - 1; i >= 0; i--)
            num += (nums.charAt(i) - 48) * ((int) Math.pow(10, (nums.length() - 1) - i));
        return num;
    }

    private static int checkMonthDay(int month) {//Проверяю кол-во дней
        return switch (month) {
            case 1, 3, 5, 7, 8, 10, 12 -> 31;
            case 4, 6, 9, 11 -> 30;
            case 2 -> 28;
            default -> 0;
        };
    }
}
