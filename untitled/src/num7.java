import java.util.Scanner;

public class num7 {
    public static void main(String[] args) { // b ghdrtsuytdu
        Scanner sc = new Scanner(System.in);
        String str, str1;

        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();
            if (str.equals("0")) {
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

            str1 = "";
            //транслитизатор латиницы в кириллицу
            for (int i = 0; i < str.length(); i++)
                str1 += Utils.transliter(str.charAt(i));
            System.out.println(str1);
        }
    }
}
