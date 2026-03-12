import java.util.Scanner;

public class num11 {
    public static boolean flagOutput = true;
    public static void setFlagOutput(boolean flag){
        flagOutput = flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lendthSize, sizeStr, wordStart, countWord;;
        String str, spaces, result, restOfWord;
        String[] words;

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
            wordStart = 0;
            countWord = 0;
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || !Utils.checkAlpha(str.charAt(i))) {
                    if (wordStart < i) {
                        countWord++;
                    }
                    wordStart = i + 1;
                }
            }
            wordStart = 0;
            words = new String[countWord];
            for (int i = 0, schet = 0; i <= str.length(); i++) {
                if (i == str.length() || str.charAt(i) == ' ') {
                    if (wordStart < i) {
                        restOfWord = str.substring(wordStart, i);
                        words[schet] = restOfWord;
                        schet++;
                    }
                    wordStart = i + 1;
                }
            }
            result = "";
            for (int i = 0; i < words.length; i++) {
                result += i == words.length - 1 ? words[i] : words[i] + " ";
            }
            if (lendthSize > 0 && (lendthSize - str.length()>=0)) {
                sizeStr = lendthSize - result.length();

                spaces = "";
                for (int i = 0; i < sizeStr; i++) {
                    spaces += " ";
                }

                if(num11.flagOutput)
                    result = spaces + result;
                else result = result + spaces;

                System.out.println("["+result+"]");
                sc.nextLine();
            }else {
                System.out.println("Ошибка ввода ширины!");
                sc.nextLine();
            }
        }
    }
}
