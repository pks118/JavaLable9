public class num10 {
    public static void main(String[] args) {
        String str = "это единица речи, что которая законченную несёт себе мысль";

        int wordStart = 0, numOfWords = 0;

        boolean flag = str.length() != 0;
        if (flag) {
            for (int i = 0; i <= str.length(); i++) {//считаю количество слов в строчке
                if (i == str.length() || str.charAt(i) == ' ') {
                    if (wordStart < i) {
                        numOfWords++;
                    }
                    wordStart = i + 1;
                }
            }
            String[] result1 = new String[numOfWords]; //создаю массив на основе слов
            numOfWords = 0;
            wordStart = 0;
            for (int i = 0; i <= str.length(); i++) { //Заполняю его
                if (i == str.length() || str.charAt(i) == ' ') {
                    if (wordStart < i) {
                        result1[numOfWords] = str.substring(wordStart, i);

                    }
                    numOfWords++;
                    wordStart = i + 1;
                }
            }
            String smallWord = result1[0],
                    bigWord = result1[0];
            for (String word : result1) {
                if (smallWord.length() > word.length()) {
                    smallWord = word;
                }
            }
            int countSmallWord = 0, countBigWord = 0;
            for (String word : result1) {
                if (smallWord.length() == word.length()) {
                    countSmallWord++;
                }
            }
            for (String word : result1) {
                if (bigWord.length() < word.length()) {
                    bigWord = word;
                }
            }
            for (String word : result1) {
                if (bigWord.length() == word.length()) {
                    countBigWord++;
                }
            }
            String[] resultSmall = new String[countSmallWord];
            String[] resultBig = new String[countBigWord];
            int index = 0;
            for (int i = 0; i < result1.length && index < resultSmall.length; i++) {//записываю минимум и максимум в отдельные массивы
                if (result1[i].length() == smallWord.length()) {
                    resultSmall[index] = result1[i];
                    index++;
                }
            }
            index = 0;
            for (int i = 0; i < result1.length && index < resultBig.length; i++) {
                if (result1[i].length() == bigWord.length()) {
                    resultBig[index] = result1[i];
                    index++;
                }
            }
            //вывод
            System.out.println("Слова с минимальным количеством символов:");
            for (String word : resultSmall)
                System.out.println(word);
            System.out.println();
            System.out.println("Слова с максимальным количеством символов:");
            for (String word : resultBig)
                System.out.println(word);

        }
    }
}
