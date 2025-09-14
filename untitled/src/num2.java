public class num2 {
    public static void main(String[] args) {
        String str = "Hello World and always come back";
        int countSp = 3, countSym = 0;
        String str2, str3 = "";

        for (int i = 0; i < str.length(); i++) {
            countSym++;
            if (str.charAt(i) == ' ') {
                str2 = str.substring(i - countSym + 1, i + 1);
                for (int k = 0; k < countSp - 1; k++)
                    str2 += " ";
                str3 += str2;
                countSym = 0;
            }
        }
        for (int i = str.length() - 1; i != 0; i--)
            if (str.charAt(i) == ' ') {
                str3 += str.substring(i + 1);
                break;
            }
        System.out.println("Пробелов между словами: " + countSp);
        System.out.println("\nСтрока до добавления пробелов:\n" + str);
        System.out.println("\nСтрока после добавления пробелов:\n" + str3);

    }
}
