import java.util.Scanner;

public class num2 {
    public static void main(String[] args) {
        int wordStart = 0, countWords = 0;
        Scanner sc = new Scanner(System.in);
        //int lendthSize = sc.nextInt();
        int lendthSize = 100;
        //String str = sc.nextLine();
        String str = "awdaw !!!!dwad dawd/////", restOfWord, result = "";
        //    wdawd! ////      dwwrgtht. dfse?

        boolean flag = str.length() != 0;
        int countSym = 0;
        for (char ch : str.toCharArray())
            if(ch != ' ') {
                countSym++;
                break;
            }
        int totalWordChars = 0; //длина слов
        if(flag && countSym > 0) {
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i)<= 47)|| (str.charAt(i) >= 58 && str.charAt(i)<= 64)|| (str.charAt(i) >= 91 && str.charAt(i)<= 96))) {
                    if (wordStart < i) {
                        countWords++;
                        totalWordChars += (i - wordStart);
                        System.out.println("Слово: " + str.substring(wordStart, i));
                    }
                    wordStart = i + 1;
                }
            }
            System.out.println();
            if(countWords > 1) {
                int baseSpaces = (lendthSize - totalWordChars) / (countWords - 1);
                int addSpaces = (lendthSize - totalWordChars) % (countWords - 1);

                System.out.println("Общее количество пробелов: " + (lendthSize - totalWordChars));
                System.out.println("Пробелов между словами: " + baseSpaces);
                System.out.println("Остаток пробелов: " + addSpaces);
                String spaces = "";
                for (int i = 0; i < baseSpaces; i++) {
                    spaces += " ";
                }
                System.out.println();

                wordStart = 0;
                int shet = 0;
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i)<= 47)|| (str.charAt(i) >= 58 && str.charAt(i)<= 64)|| (str.charAt(i) >= 91 && str.charAt(i)<= 96))) {
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
            }
            else if (countWords == 1) { // Условие с одним словом
                wordStart = 0;
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || !((str.charAt(i) >= 'A' && str.charAt(i) <= 'Z')|| (str.charAt(i) >= 'a' && str.charAt(i)<= 'z'))) {
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
            System.out.println("Исходная строчка: ["+str+']');
            System.out.println("Длина исходной строчки: "+str.length()+"\n");
            System.out.println("Итоговоая строчка: ["+ result + ']');
            System.out.println("Длина итоговой строчки: "+result.length());
            System.out.println("Необходимая длина: " + lendthSize);
        }
    }
}
