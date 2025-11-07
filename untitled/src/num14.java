import java.util.Scanner;

public class num14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        num11 fl = new num11();
        int hudMenu;
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите пункт меню:\n1. Выравнивание по левому краю;\n2. Выравнивание по правому краю;\n3. Выравнивание по центру;\n4. Выравнивание по ширине.");
            System.out.print("Введите пункт меню (для выхода введите '0'): ");
            if (sc.hasNextInt())
                hudMenu = sc.nextInt();
            else hudMenu = -1;
            switch (hudMenu) {
                case 0:
                    System.out.println("Выход из программы.");
                    flag = false;
                    break;
                case 1:
                    fl.setFlagOutput(true);
                    num11.main(args);
                    break;
                case 2:
                    fl.setFlagOutput(false);
                    num11.main(args);
                    break;
                case 3:
                    num3.main(args);
                    break;
                case 4:
                    num2.main(args);
                    break;
                default:
                    System.out.println("Ошибка");
                    sc.nextLine();
                    break;
            }
        }
    }
}
