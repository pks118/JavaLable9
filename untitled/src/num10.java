import java.util.Scanner;

public class num10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        int wordStart = 0, numOfWords = 0;
        int countSmallWord, countBigWord;
        boolean flag;
        System.out.println("Для выхода введите '0' ");
        String smallWord;
        String bigWord;
        String[] resultSmall;
        String[] resultBig;
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = !str.isEmpty();
            if (flag) {
                for (int i = 0; i <= str.length(); i++) {//считаю количество слов в строчке
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96))) {
                        if (wordStart < i) {
                            numOfWords++;
                        }
                        wordStart = i + 1;
                    }
                }
                String[] result1 = new String[numOfWords]; //создаю массив на основе слов
                System.out.println(result1.length);
                numOfWords = 0;
                wordStart = 0;
                for (int i = 0; i <= str.length(); i++) { //Заполняю его
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96))) {
                        if (wordStart < i) {
                            result1[numOfWords] = str.substring(wordStart, i);
                            numOfWords++;
                        }
                        wordStart = i + 1;
                    }
                }
                numOfWords = 0;
                wordStart = 0;
                smallWord = result1[0];
                bigWord = result1[0];
                for (String word : result1) {//нахожу самое маленькое слово
                    if (smallWord.length() > word.length()) {
                        smallWord = word;
                    }
                }
                countSmallWord = countWords(result1, smallWord);
                for (String word : result1) {
                    if (bigWord.length() < word.length()) {
                        bigWord = word;
                    }
                }
                countBigWord = countWords(result1, bigWord);
                resultSmall = new String[countSmallWord];//массив маленьких слов
                resultBig = new String[countBigWord];
                fillingInArrays(result1, resultSmall, smallWord);
                fillingInArrays(result1, resultBig, bigWord);

                System.out.println("Слова с минимальным количеством символов:");
                output(resultSmall);
                System.out.println();
                System.out.println("Слова с максимальным количеством символов:");
                output(resultBig);
            } else {
                System.out.println("Был замечен неверный паттерн ввода! Убедительная просьба ввести данные повторно!");
            }
        }
    }
    //запись минимальных и максимальных слов в отдельные массивы
    private static void fillingInArrays(String[] str, String[] result_words, String word) {
        for (int i = 0, index = 0; i < str.length && index < result_words.length; i++) {
            if (str[i].length() == word.length()) {
                result_words[index] = str[i];
                index++;
            }
        }
    }
    //Вывод
    private static void output(String[] result_words) {
        for (String word : result_words)
            System.out.println(word);
    }
    //подсчет количества слов с длинной символов слова
    private static int countWords(String[] str, String word) {
        int count_word = 0;
        for (String str_word : str) {
            if (word.length() == str_word.length()) {
                count_word++;
            }
        }
        return count_word;
    }
}
