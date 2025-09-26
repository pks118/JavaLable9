import java.util.Scanner;

public class num2 {
    public static void main(String[] args) {
        int wordStart = 0, countWords = 0;
        //Scanner sc = new Scanner(System.in);
        //int lendthSize = sc.nextInt();
        int lendthSize = 100;
        String str = "   wdawd dwwrgtht dfse   ", restOfWord, result = "";

        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == ' ') {
                if (wordStart < i) {
                    countWords++;
                }
                wordStart = i + 1;
            }

        }
        double shiftSpace = (lendthSize - (double) str.length()) / (countWords - 1);
        String spaces = "";
        for (int i = 0; i < (int) shiftSpace; i++) {
            spaces += " ";
        }
        System.out.println(spaces.length());
        System.out.println(shiftSpace + "|" + str.length());
        wordStart = 0;
        int shet = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == ' ') {
                if (wordStart < i) {
                    restOfWord = str.substring(wordStart, i);
                    if (shet < countWords - 1) {
                        result += restOfWord + spaces;
                        shet++;

                    } else
                        result += restOfWord;

                }
                wordStart = i + 1;
            }

        }
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                result = str.substring(0, i) + result;
                break;
            }
        }
        for (int i = str.length()-1; i != 0; i--) {
            if (str.charAt(i) != ' ') {
                System.out.println(i);
                result += str.substring(i+1);
                break;
            }
        }
        System.out.println(str);
        System.out.println(str.length());
        System.out.println(result);
        System.out.println(result.length());


    }
}
