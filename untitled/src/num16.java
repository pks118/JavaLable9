import java.util.Scanner;

public class num16 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        //A(2, 5), B(7, 5), C(7, 3)
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();

        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        double x3 = sc.nextDouble();
        double y3 = sc.nextDouble();

        double find1 = findForFourth(x1, x2, x3);
        double find2 = findForFourth(y1, y2, y3);

        System.out.println("D["+find1+", "+find2+"]");


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
