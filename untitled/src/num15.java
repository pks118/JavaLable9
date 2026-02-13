import java.util.InputMismatchException;
import java.util.Scanner;

public class num15 {
    private double a;
    private double b;
    private double c;

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    public void setA(double num) {
        this.a = num;
    }

    public void setB(double num) {
        this.b = num;
    }

    public void setC(double num) {
        this.c = num;
    }

    public void showMe() {
        System.out.println("Сторона А: " + a);
        System.out.println("Сторона Б: " + b);
        System.out.println("Сторона С: " + c);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num15 treugol = new num15();
        //5, 5, 5 Существует (равносторонний)
        //1, 1, 3 Не существует
        // 3, 4, 5 Существует
        boolean flag = true;
        String err = "";
        String exit;
        while (true) {
            try {
                System.out.print("Введите точку А:");
                treugol.setA(sc.nextDouble());
                System.out.print("Введите точку В:");
                treugol.setB(sc.nextDouble());
                System.out.print("Введите точку С:");
                treugol.setC(sc.nextDouble());
            } catch (InputMismatchException e) {
                flag = false;
                err = "Ошибка ввода!";
                sc.nextLine();
            }
            if (flag) {
                treugol.showMe();
                if ((treugol.getA() > 0 && treugol.getB() > 0 && treugol.getC() > 0) && (treugol.getA() + treugol.getB() > treugol.getC()) && (treugol.getA() + treugol.getC() > treugol.getB()) && (treugol.getB() + treugol.getC() > treugol.getA()))
                    System.out.println("Треугольник существует!");
                else {
                    System.out.println("Треугольник не существует!");
                    flag = false;
                }
                if (flag) {
                    if (treugol.getA() == treugol.getB() && treugol.getB() == treugol.getC())
                        System.out.println("Это равносторонний треугольник");
                    else {
                        System.out.println("Это не равносторонний треугольник");
                        flag = true;
                    }
                }else {
                    flag = true;
                }
            } else {
                System.out.println(err);
                flag = true;
            }
            System.out.print("Хотите продолжить? (Для выхода введите 'y' ): ");
            exit = sc.next();
            if (!exit.equals("y")) {
                System.out.println("Выход из программы.");
                break;
            }
        }
    }
}
