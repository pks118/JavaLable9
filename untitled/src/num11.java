import java.util.Scanner;

public class num11 {
    public static boolean flagOutput = true;
    public static void setFlagOutput(boolean flag){
        flagOutput = flag;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lendthSize, sizeStr;
        String str, spaces, result;

        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }

            if (Utils.emptyStr(str)) {
                System.out.println("Строчка пуста!");
                continue;
            }

            if (Utils.onlySpaces(str)) {
                System.out.println("В строчке только пробелы!");
                continue;
            }

            System.out.print("Введите ширину строки: ");
            lendthSize = sc.hasNextInt() ? sc.nextInt() : -1;
            if (lendthSize == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            if (lendthSize > 0 && (lendthSize - str.length()>0)) {
                sizeStr = lendthSize - str.length();

                spaces = "";
                for (int i = 0; i < sizeStr; i++) {
                    spaces += " ";
                }

                if(num11.flagOutput)
                    result = spaces + str;
                else result = str + spaces;

                System.out.println("["+result+"]");
                sc.nextLine();
            }else {
                System.out.println("Ошибка ввода ширины!");
                sc.nextLine();
            }
        }
    }
}
