import java.util.Scanner;

public class num5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        // Gfresef///// fesee /////troier //////   rifjr
        boolean flag;
        int wordStart = 0;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() > 0;
            if (flag) {
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i) <= 47) || (str.charAt(i) >= 58 && str.charAt(i) <= 64) || (str.charAt(i) >= 91 && str.charAt(i) <= 96))) {
                        if (wordStart < i)
                            System.out.println(str.substring(wordStart, i));
                        wordStart = i + 1;
                    }
                }
                wordStart = 0;
            }
            else {
                System.out.println("Был замечан не верный паттерн ввода! Убедительная просьба ввести данные повторно!");
            }
        }
    }
}
