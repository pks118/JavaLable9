import java.util.Scanner;

public class num2 {
    public static void main(String[] args) {
        int wordStart = 0, countWords = 0;
        Scanner sc = new Scanner(System.in);
        //int lendthSize = sc.nextInt();
        int lendthSize = 100;
        //String str = sc.nextLine();
        String str = "   wdawd! //// dwwrgtht. dfse?   ", restOfWord, result = "";

        boolean flag = str.length() != 0;
        int countSym = 0;
        for (char ch : str.toCharArray())
            if(ch != ' ') {
                countSym++;
                break;
            }
        if(flag && countSym > 0) {
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i)<= 47)|| (str.charAt(i) >= 58 && str.charAt(i)<= 64)|| (str.charAt(i) >= 91 && str.charAt(i)<= 96))) {
                    if (wordStart < i) {
                        countWords++;
                        System.out.println("clovo");
                    }
                    wordStart = i + 1;
                    System.out.println( wordStart);
                }
            }
            if(countWords > 1) {
                double shiftSpace = (lendthSize - (double) str.length()) / (countWords - 1);
                System.out.println(shiftSpace);
                String spaces = "";
                for (int i = 0; i < (int) shiftSpace; i++) {
                    spaces += " ";
                }
                double addSpaces = (((double) (spaces.length() + countWords - 1) / (countWords - 1)) - (spaces.length() + countWords - 1) / (countWords - 1)) * (countWords - 1);
                System.out.println(addSpaces);
                wordStart = 0;
                int shet = 0;
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i)<= 47)|| (str.charAt(i) >= 58 && str.charAt(i)<= 64)|| (str.charAt(i) >= 91 && str.charAt(i)<= 96))) {
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
                spaces = spaces.substring(0, (lendthSize - result.length())/(countWords-1));
                System.out.println(spaces.length()+"!"+result.length()+"!"+lendthSize);
                System.out.println(str);
                System.out.println(str.length());
                System.out.println(result);
                System.out.println(result.length());
            }
        }
    }
}
