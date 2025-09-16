import java.util.Scanner;

public class num9 {
    public static void main(String[] args) {
        System.out.println("Введите дату в формате: ДД.ММ.ГГГГ");
        Scanner sc = new Scanner(System.in);
        String date = sc.nextLine();
        String error = "Ошибка: вы вышли за границы формата!";
        boolean flag = true;
        int stage = 0;

        for (int i = 0; i < date.length(); i++) {
            if ((!(date.charAt(i) >= '0' && date.charAt(i) <= '9')) && date.charAt(i) != '.') {
                error = "Ошибка: \"" + date.charAt(i) + "\" не допустимый формат!";
                flag = false;
                break;
            } else if ((date.charAt(i) == '.')) {
                if (i != 2 && stage == 0) {
                    error = "Ошибка: дата \"" + date.substring(0, i) + "\" введена не корректно!";
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
        if (flag && date.length() == 10) {
            if (checkingEnteredDay(date.substring(0,2))<=31)
                System.out.println(date.substring(0, 2));
            else
                System.out.println("Ошибка: некорректная дата: \"" + date.substring(0, 2) + "\" !");
            System.out.println(error);

            System.out.println(date.substring(3, 5));
            System.out.println(date.substring(6));
        } else System.out.println(error);
    }
    private static int checkingEnteredDay (String num)
    {
        return Integer.parseInt(num);
    }
}
