import java.util.Scanner;

public class num10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int wordStart, numOfWords, countSmallWord, countBigWord;
        System.out.println("Для выхода введите '0' ");
        String smallWord, bigWord, str;
        String[] resultSmall, resultBig;

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

            wordStart = numOfWords = 0;
            for (int i = 0; i <= str.length(); i++) {//считаю количество слов в строчке
                if (i == str.length() || !Utils.checkAlpha(str.charAt(i))) {
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
                if (i == str.length() || !Utils.checkAlpha(str.charAt(i))) {
                    if (wordStart < i) {
                        result1[numOfWords] = str.substring(wordStart, i);
                        numOfWords++;
                    }
                    wordStart = i + 1;
                }
            }

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
        }
    }

    private static void fillingInArrays(String[] str, String[] result_words, String word) {
        for (int i = 0, index = 0; i < str.length && index < result_words.length; i++) {
            if (str[i].length() == word.length()) {
                result_words[index] = str[i];
                index++;
            }
        }
    }

    private static void output(String[] result_words) {
        for (String word : result_words)
            System.out.println(word);
    }

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
