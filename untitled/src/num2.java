import java.util.Scanner;

public class num2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lendthSize;//ширина
        String str;//строчка
        String result = "";
        String restOfWord = "";
        //a    wd///aw !!!!dwad dawd/////
        int countSym = 0;//кол-во символов
        int totalWordSym = 0; //длина слов
        int wordStart = 0;//начало слов
        int countWords = 0;//кол-во слов
        int baseSpaces;
        int addSpaces;
        boolean flag;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            System.out.print("Введите ширину строки: ");
            lendthSize = sc.nextInt();//ширина
            if (lendthSize == 0) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() > 0 && lendthSize > 0;
            for (char ch : str.toCharArray())
                if (ch != ' ') {
                    countSym++;
                    break;
                }
            if (flag && countSym > 0 && (lendthSize - str.length()>0)) {
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96))) {
                        if (wordStart < i) {
                            countWords++;
                            totalWordSym += (i - wordStart);
                            System.out.println("Слово: " + str.substring(wordStart, i));
                        }
                        wordStart = i + 1;
                    }
                }
                System.out.println();
                if (countWords > 1) {
                    baseSpaces = (lendthSize - totalWordSym) / (countWords - 1);
                    addSpaces = (lendthSize - totalWordSym) % (countWords - 1);
                    System.out.println("Общее количество пробелов: " + (lendthSize - totalWordSym));
                    System.out.println("Пробелов между словами: " + baseSpaces);
                    System.out.println("Остаток пробелов: " + addSpaces);
                    String spaces = "";
                    for (int i = 0; i < baseSpaces; i++) {
                        spaces += " ";
                    }
                    System.out.println();

                    wordStart = 0;
                    for (int i = 0, shet = 0; i <= str.length(); i++) {
                        if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96))) {
                            if (wordStart < i) {
                                restOfWord = str.substring(wordStart, i);
                                result += restOfWord;
                                if (shet < countWords - 1) {
                                    result += spaces;
                                    if (shet < addSpaces) {
                                        result += " ";
                                    }
                                }
                                shet++;
                            }
                            wordStart = i + 1;
                        }
                    }
                } else if (countWords == 1) { // Условие с одним словом
                    wordStart = 0;
                    for (int i = 0; i <= str.length(); i++) {
                        if (i == str.length() || !((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') || (str.charAt(i) >= 'a' && str.charAt(i) <= 'z'))) {
                            if (wordStart < i) {
                                result = str.substring(wordStart, i);
                                while (result.length() < lendthSize) {
                                    result += " ";
                                }
                                break;
                            }
                            wordStart = i + 1;
                        }
                    }
                }
                System.out.println("Исходная строчка: [" + str + ']');
                System.out.println("Длина исходной строчки: " + str.length() + "\n");
                System.out.println("Итоговоая строчка: [" + result + ']');
                System.out.println("Длина итоговой строчки: " + result.length());
                System.out.println("Необходимая длина: " + lendthSize);
                sc.nextLine();
                wordStart = 0;
            } else {
                System.out.println("Был замечен неверный паттерн ввода! Убедительная просьба ввести данные повторно!");
                sc.nextLine();
            }
        }
    }
}
