import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String result = "";
        boolean flag;
        while (true) {
            System.out.print("Введите строку (для выхода введите 'y'): ");
            str = sc.nextLine();
            if (str.equals("y")) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() != 0;
            if (flag && (str.charAt(0) != ' ' && str.charAt(str.length() - 1) != ' ')) {
                result = str;
            }else if(!flag){
                System.out.println("Строчка пуста!");
            } else {
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) != ' ') {
                        result = str.substring(i);
                        break;
                    }
                }
                System.out.println(result);
                for (int i = result.length() - 1; i != 0; i--) {
                    if (result.charAt(i) != ' ') {
                        result = result.substring(0, i + 1);
                        break;
                    }
                }
            }
            if(flag) {
                System.out.println("Исходный вариант: [" + str + "]");
                System.out.println("Результат: [" + result + "]");
            }
        }
    }
}