import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, result = "";

        while (true) {
            System.out.print("Введите строку (для выхода введите 'y'): ");
            str = sc.nextLine();

            if (str.equals("y")) {
                System.out.println("Выход из программы.");
                break;
            }

            if (Utils.emptyStr(str)) {
                System.out.println("Строчка пуста!");
                continue;
            }

            if (Utils.onlySpaces(str)) {
                System.out.println("В строчке только пробелы!");
                continue;
            }

            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result = str.substring(i);
                    break;
                }
            }

            for (int i = result.length() - 1; i != 0; i--) {
                if (result.charAt(i) != ' ') {
                    result = result.substring(0, i + 1);
                    break;
                }
            }

            System.out.println("Исходный вариант: [" + str + "]");
            System.out.println("Результат: [" + result + "]");
        }
    }
}