//String num16 = "3A7";
//935
import java.util.Scanner;

public class num8 {
    public static void main(String[] args) {
        int num10;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 16-ое число: ");
        String alpha = "0123456789ABCDEF", num16;
        boolean flag;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            num16 = sc.nextLine();
            if (num16.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            if (Utils.emptyStr(num16)) {
                System.out.println("Строчка пуста!");
                continue;
            }

            flag = true;
            for (int i = 0; i < num16.length(); i++) {
                if(alpha.indexOf(num16.charAt(i)) == -1) {
                    System.out.println("Введено некорректное значение!");
                    flag = false;
                    break;
                }
            }
            num10 = 0;
            if (flag) {
                double pow;
                for (int i = num16.length() - 1; i >= 0; i--) {
                    pow = Math.pow(16, num16.length() - 1 - i);
                    num10 += (from16To10(num16.charAt(i), alpha)) * pow;
                    System.out.println((num16.length() - i) + ") " + (from16To10(num16.charAt(i), alpha)) + " * " + pow + " = " + num10);
                }
                System.out.println(num16 + "_16 = " + num10 + "_10");
            }
        }
    }
    private static int from16To10(char num16, String alph) {
        return alph.indexOf(num16);
    }
}

