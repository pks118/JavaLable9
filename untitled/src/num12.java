import java.util.Scanner;

public class num12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordStart = 0;
        String str, restOfWord = "", result;
        boolean flag;
        int count_word;
        String [] words;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            result = "";
            count_word = 0;
            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() > 0;
            if (flag) {
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96))) {
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
                wordStart = 0;
                for (int i = 0; i < words.length; i++){
                    if(i == words.length-1)
                        result += words[i];
                    else
                        result += words[i] + " ";
                }
                System.out.println(result);
            } else {
                System.out.println("Был замечан не верный паттерн ввода! Убедительная просьба ввести данные повторно!");
            }
        }
    }
}
