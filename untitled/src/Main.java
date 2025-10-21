import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строчку:");
        String str = sc.nextLine();

        boolean flag = str.length() != 0;
        int countSym = 0;
        for (char ch : str.toCharArray())
            if(ch != ' ') {
                countSym++;
                break;
            }


        if(flag && countSym > 0) {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) != ' ') {
                    str = str.substring(i);
                    break;
                }
            }
            for (int i = str.length() - 1; i != 0; i--) {
                if (str.charAt(i) != ' ') {
                    str = str.substring(0, i);
                    break;
                }
            }
            System.out.println(str);
        }
    }
}