//Esfuseh eufhuesi sefeu uhsuehfus
import java.util.Scanner;

public class num4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, restOfWord, result;
        int wordStart = 0;
        char firstChar, capitalized;
        System.out.println("Для выхода введите '0' ");
        while (true) {

            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
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
            result = "";
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || str.charAt(i) == ' ') {
                    if (wordStart < i) {
                        firstChar = str.charAt(wordStart);
                        restOfWord = str.substring(wordStart + 1, i);
                        capitalized = Utils.toUpperCase(firstChar);// преобразую символ в заглавный, если это не буква возвращаю обратно
                        result += capitalized + restOfWord;
                        if (i < str.length()) {
                            result += " ";
                        }
                    }
                    wordStart = i + 1;
                }
            }
            wordStart = 0;
            System.out.println(result);
        }
    }
}