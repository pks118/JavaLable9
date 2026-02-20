import java.util.Scanner;

public class num14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hudMenu;
        boolean flag = true;
        while (flag) {
            System.out.println("Выберите пункт меню:\n1. Выравнивание по левому краю;\n2. Выравнивание по правому краю;\n3. Выравнивание по центру;\n4. Выравнивание по ширине.");
            System.out.print("Введите пункт меню (для выхода введите '0'): ");
            hudMenu = sc.hasNextInt() ? sc.nextInt() : -1;
            switch (hudMenu) {
                case 0:
                    System.out.println("Выход из программы.");
                    flag = false;
                    break;
                case 1:
                    num11.setFlagOutput(true);
                    num11.main(args);
                    break;
                case 2:
                    num11.setFlagOutput(false);
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
