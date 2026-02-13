import java.util.Scanner;

public class num11 {
    public static boolean flagOutput = true;
    public void setFlagOutput(boolean flag){
        flagOutput = flag;
    }
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
            flag = !str.isEmpty() && lendthSize > 0;
            if (flag) {
                sizeStr = lendthSize - str.length();
                for (int i = 0; i < sizeStr; i++) {
                    spaces += " ";
                }
                if(num11.flagOutput)
                    result = spaces + str;
                else result = str + spaces;
                System.out.println("["+result+"]");
                sc.nextLine();
                spaces="";
            }else {
                System.out.println("Был замечен неверный паттерн ввода! Убедительная просьба ввести данные повторно!");
                sc.nextLine();
            }
        }
    }
}
