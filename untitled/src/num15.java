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
        treugol.setA(sc.nextDouble());
        treugol.setB(sc.nextDouble());
        treugol.setC(sc.nextDouble());

        treugol.showMe();

        boolean flag = true;
        if ((treugol.getA() > 0 && treugol.getB() > 0 && treugol.getC() > 0) && (treugol.getA() + treugol.getB() > treugol.getC()) && (treugol.getA() + treugol.getC() > treugol.getB()) && (treugol.getB() + treugol.getC() > treugol.getA()))
            System.out.println("Треугольник существует!");
        else {
            System.out.println("Треугольник не существует!");
            flag = false;
        }

        if(flag)
            if (treugol.getA() == treugol.getB() && treugol.getB() == treugol.getC())
                System.out.println("Это равносторонний треугольник");
            else System.out.println("Это не равносторонний треугольник");
    }
}
