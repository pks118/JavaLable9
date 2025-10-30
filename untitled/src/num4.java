import java.util.Scanner;

public class num4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        //Esfuseh eufhuesi sefeu uhsuehfus
        String result = "";
        String restOfWord;
        int wordStart = 0;
        char firstChar, capitalized;
        boolean flag;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() > 0;
            if (flag) {
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || str.charAt(i) == ' ') {
                        if (wordStart < i) {
                            firstChar = str.charAt(wordStart);
                            restOfWord = str.substring(wordStart + 1, i);
                            capitalized = toUpperCase(firstChar);// преобразую символ в заглавный, если это не буква возвращаю обратно
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
                result = "";
            } else {
                System.out.println("Был замечан не верный паттерн ввода! Убедительная просьба ввести данные повторно!");
            }
        }
    }

    private static char toUpperCase(char c) {

        if (c >= 'а' && c <= 'я') { //проверяю символ на наличие кириллицы
            return (char) (c - 32);
        } else if (c == 'ё') {//Исключаю Ё
            return 'Ё';
        } else if (c >= 'a' && c <= 'z') {// Для латиницы
            return (char) (c - 32);
        }
        return c;
    }
}