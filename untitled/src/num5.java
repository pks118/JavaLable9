// Gfresef///// fesee /////troier //////   rifjr
import java.util.Scanner;

public class num5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int wordStart = 0;
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

            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || !Utils.checkAlpha(str.charAt(i))) {
                    if (wordStart < i)
                        System.out.println(str.substring(wordStart, i));
                    wordStart = i + 1;
                }
            }
            wordStart = 0;
        }
    }
}
