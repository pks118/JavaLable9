import java.util.Scanner;

public class num11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lendthSize;
        int sizeStr;
        String str;
        String spaces = "";
        String result;
        boolean flag;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            System.out.print("Введите ширину строки: ");
            if(sc.hasNextInt())
                lendthSize = sc.nextInt();
            else lendthSize=-1;

            if (lendthSize == 0) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() > 0 && lendthSize > 0;
            if (flag) {
                sizeStr = lendthSize - str.length();
                for (int i = 0; i < sizeStr; i++) {
                    spaces += " ";
                }
                result = spaces + str;
                System.out.println(result);
            }else {
                System.out.println("Был замечан не верный паттерн ввода! Убедительная просьба ввести данные повторно!");
            }
        }
    }
}
