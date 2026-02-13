import java.util.InputMismatchException;
import java.util.Scanner;

public class num16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //A(2, 5), B(7, 5), C(7, 3)
        boolean flag;
        String exit;
        double x1 = 0.0;
        double y1 = 0.0;
        double x2 = 0.0;
        double y2 = 0.0;
        double x3 = 0.0;
        double y3 = 0.0;
        double find1, find2;
        while (true) {
            flag = true;
            try {
                System.out.print("Введите точку x1:");
                x1 = sc.nextDouble();
                System.out.print("Введите точку y1:");
                y1 = sc.nextDouble();
                System.out.print("Введите точку x2:");
                x2 = sc.nextDouble();
                System.out.print("Введите точку y2:");
                y2 = sc.nextDouble();
                System.out.print("Введите точку x3:");
                x3 = sc.nextDouble();
                System.out.print("Введите точку y3:");
                y3 = sc.nextDouble();
            } catch (InputMismatchException e) {
                flag = false;
                sc.nextLine();
            }
            if (flag) {
                find1 = findForFourth(x1, x2, x3);
                find2 = findForFourth(y1, y2, y3);
                System.out.println("D[" + find1 + ", " + find2 + "]");
            } else {
                System.out.println("Ошибка ввода!");
            }
            System.out.print("Хотите продолжить? (Для выхода введите 'y' ): ");
            exit = sc.next();
            if (!exit.equals("y")) {
                System.out.println("Выход из программы.");
                break;
            }
        }
    }

    private static double findForFourth(double x1, double x2, double x3){
        double find = 0.0;
        if (x1 == x2)
            find = x3;
        else if (x1 == x3)
            find = x2;
        else if (x2 == x3)
            find = x1;
        return find;
    }
}
