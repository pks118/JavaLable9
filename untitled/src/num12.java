import java.util.Scanner;

public class num12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordStart, count_word;
        String str, restOfWord, result;
        String[] words;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            count_word = 0;
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
            wordStart = 0;
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || !Utils.checkAlpha(str.charAt(i))) {
                    if (wordStart < i) {
                        count_word++;
                    }
                    wordStart = i + 1;
                }
            }
            wordStart = 0;
            words = new String[count_word];
            for (int i = 0, schet = 0; i <= str.length(); i++) {
                if (i == str.length() || str.charAt(i) == ' ') {
                    if (wordStart < i) {
                        restOfWord = str.substring(wordStart, i);
                        words[schet] = restOfWord;
                        schet++;
                    }
                    wordStart = i + 1;
                }
            }
            result = "";
            for (int i = 0; i < words.length; i++) {
                if (i == words.length - 1)
                    result += words[i];
                else
                    result += words[i] + " ";
            }
            System.out.println("Исходная строчка: [" + str + ']');
            System.out.println("Итоговоая строчка: [" + result + ']');
        }
    }
}
