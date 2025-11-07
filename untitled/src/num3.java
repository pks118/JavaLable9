import java.util.Scanner;

public class num3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lendthSize;//ширина
        String str;
        String result;
        boolean flag;
        int countSym = 0;//кол-во символов в строчке
        int countWords = 0;//кол-во слов
        int wordStart = 0;//начало слова
        int totalWordSym = 0; //длина слов
        int baseSpaces;//общее кол-во пробелов
        int leftCountSpaces;//пробелы слева
        int rightCountSpaces;//пробелы справа
        String leftSpaces;
        String rightSpaces;
        String restOfWord;
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
                        if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96))) {
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
                System.out.println("Был замечен неверный паттерн ввода! Убедительная просьба ввести данные повторно!");
                sc.nextLine();
            }
            countSym = 0;
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
