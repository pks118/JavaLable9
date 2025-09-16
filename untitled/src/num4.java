public class num4 {
    public static void main(String[] args) {
        String str = "hello world and always come back";
        String result = "", restOfWord;
        int wordStart = 0;
        char firstChar, capitalized;

        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == ' ') {
                if (wordStart < i) {
                    firstChar = str.charAt(wordStart);
                    restOfWord = str.substring(wordStart + 1, i);


                    capitalized = toUpperCase(firstChar);// преобразую символ в заглавный, если это не буква возвращаю обратно
                    System.out.println(capitalized);
                    result += capitalized + restOfWord;
                    System.out.println(result);
                    if (i < str.length()) {
                        result += " ";
                    }
                }
                wordStart = i + 1;
            }
        }
        System.out.println(result);
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