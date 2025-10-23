import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String result = "";
        boolean flag = str.length() != 0;
        if (flag && (str.charAt(0) != ' ' && str.charAt(str.length() - 1) != ' ')) {
            result = str;
        } else {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    result = str.substring(i);
                    break;
                }
            }
            System.out.println(result);
            for (int i = result.length() - 1; i != 0; i--) {
                if (str.charAt(i) != ' ' && str.charAt(str.length() - 1) == ' ') {
                    result = result.substring(0, i + 1);
                    break;
                }
            }
        }
        System.out.println("Исходный вариант: [" + str + "]");
        System.out.println("Результат: [" + result + "]");
    }
}