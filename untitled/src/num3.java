import java.util.Scanner;

public class num3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countWords, wordStart, totalWordSym;//кол-во символов в строчке
        countWords = wordStart = totalWordSym = 0;
        int lendthSize, baseSpaces, leftCountSpaces, rightCountSpaces;//общее кол-во пробелов
        String leftSpaces, rightSpaces, restOfWord, str, result;
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

            System.out.print("Введите ширину строки: ");
            lendthSize = sc.hasNextInt() ? sc.nextInt() : -1;

            if (lendthSize == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            if (lendthSize > 0 && (lendthSize - str.length()>0)) {
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || !Utils.checkAlpha(str.charAt(i))) {
                        if (wordStart < i) {
                            countWords++;
                            totalWordSym += (i - wordStart);
                            System.out.println("Слово: " + str.substring(wordStart, i));
                        }
                        wordStart = i + 1;
                    }
                }
                result = "";
                if (countWords > 1) {
                    baseSpaces = lendthSize - (totalWordSym + (countWords - 1));
                    totalWordSym = 0;
                    leftCountSpaces = baseSpaces / 2;
                    rightCountSpaces = baseSpaces - leftCountSpaces;
                    System.out.println("Общее количество пробелов: " + baseSpaces);
                    leftSpaces = generatingSp(leftCountSpaces);
                    rightSpaces = generatingSp(rightCountSpaces);
                    System.out.println();
                    wordStart = 0;
                    for (int i = 0, shet = 0; i <= str.length(); i++) {
                        if (i == str.length() || !Utils.checkAlpha(str.charAt(i))) {
                            if (wordStart < i) {
                                restOfWord = str.substring(wordStart, i);
                                result += restOfWord;
                                if (shet < countWords - 1) {
                                    result += " ";
                                }
                                shet++;
                            }
                            wordStart = i + 1;
                        }
                    }
                    result = leftSpaces + result + rightSpaces;
                }
                countWords = 0;
                wordStart = 0;
                System.out.println("Исходная строчка: [" + str + ']');
                System.out.println("Длина исходной строчки: " + str.length() + "\n");
                System.out.println("Итоговоая строчка: [" + result + ']');
                System.out.println("Длина итоговой строчки: " + result.length());
                System.out.println("Необходимая длина: " + lendthSize);
                sc.nextLine();
            } else {
                System.out.println("Ошибка ввода ширины!");
                sc.nextLine();
            }
        }
    }
    public static String generatingSp(int countSp){
        String spaces = "";
        for (int i = 0; i < countSp; i++) {
            spaces += " ";
        }
        return spaces;
    }
}
