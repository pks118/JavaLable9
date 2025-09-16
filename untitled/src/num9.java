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
                if (i != 2 && stage == 0) {//проверяю стоит ли точка на своём месте
                    error = "Ошибка: день \"" + date.substring(0, i) + "\" введена не корректно!";
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


        if (flag && date.length() == 10) {//проверяю на наличие ошибки и вышел ли пользователь за допустимый формат
            if (checkingEnteredNumber(date.substring(0,2))>31) {//проверка даты и.т.д
                flag = false;
                error = "Ошибка: некорректная дата: \"" + date.substring(0, 2) + "\" !";
            }
            if (checkingEnteredNumber(date.substring(3,5))>12 || checkingEnteredNumber(date.substring(3,5))<1) {
                flag = false;
                error = "Ошибка: некорректный месяц: \"" + date.substring(3, 5) + "\" !";
            }

            if (checkingEnteredNumber(date.substring(6))<1925 || checkingEnteredNumber(date.substring(6))>2025) {
                flag = false;
                error = "Ошибка: некорректный год: \"" + date.substring(6) + "\" !";
            }
        } else System.out.println(error);



        if (flag)//вывод
            System.out.println(date.substring(0,2)+"\n"+date.substring(3, 5)+"\n"+date.substring(6));
        else
            System.out.println(error);
    }
    private static int checkingEnteredNumber (String nums)//конвертирую из строки в число
    {
        int num = 0;
        for (int i = nums.length()-1; i>=0; i--)
            num += (nums.charAt(i) - 48) * ((int) Math.pow(10, (nums.length()-1)-i));
        return num;
    }
}
