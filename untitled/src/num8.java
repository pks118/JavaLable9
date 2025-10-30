import java.util.Scanner;

public class num8 {
    public static void main(String[] args) {
        int num10 = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите 16-ое число: ");
        String num16;
        //String num16 = "3A7";
        //935
        boolean flag;
        String error = "";
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            num16 = sc.nextLine();//строчка
            if (num16.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = num16.length() > 0;
            if (!flag) {
                error = "Пусто!";
            }
            for (int i = 0; i < num16.length(); i++) {
                if (!(num16.charAt(i) >= '0' && num16.charAt(i) <= '9') && !((num16.charAt(i) >= 'A' || num16.charAt(i) >= 'a') && (num16.charAt(i) <= 'F' || num16.charAt(i) <= 'f'))) {
                    error = "Введено некорректное значение!";
                    flag = false;
                }
            }
            if (flag) {
                for (int i = num16.length() - 1; i >= 0; i--) {
                    double pow = Math.pow(16, num16.length() - 1 - i);
                    if ((num16.charAt(i) >= '0' && num16.charAt(i) <= '9')) {
                        num10 += (num16.charAt(i) - 48) * pow; //Math.pow(16, num16.length() - 1 - i);
                        System.out.println((num16.length() - i) + ") " + (num16.charAt(i) - 48) + " * " + (pow) + " = " + num10);
                    } else if ((num16.charAt(i) >= 'A' || num16.charAt(i) >= 'a') && (num16.charAt(i) <= 'F' || num16.charAt(i) <= 'f')) {
                        num10 += from16To10(num16.charAt(i)) * pow; //Math.pow(16, num16.length() - 1 - i);
                        System.out.println((num16.length() - i) + ") " + (from16To10(num16.charAt(i))) + " * " + (pow) + " = " + num10);
                    } else {
                        System.out.println("Введено некорректное значение!");
                        break;
                    }
                }
                System.out.println(num16 + "_16 = " + num10 + "_10");
            } else System.out.println(error);
        }
    }

    private static int from16To10(char num16) {
        char[] numbers16;
        if ((num16 >= 'a') && (num16 <= 'f'))
            numbers16 = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        else
            numbers16 = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        for (int i = 0; i < numbers16.length; i++)
            if (num16 == numbers16[i])
                return i + 10;
        return num16;
    }
}

