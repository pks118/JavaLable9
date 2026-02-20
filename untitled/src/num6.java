import java.util.Scanner;

public class num6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int shift_ch;
        String str ,str2, str3;

        System.out.println("Для выхода введите '0' ");
        while (true) {

            System.out.print("Введите строку: ");
            str = sc.nextLine();
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

            System.out.println("Алфавит");
            for(int i = 0; i<Utils.alphabetBm.length; i++){
                if(i == Utils.alphabetBm.length-1)
                    System.out.print(Utils.alphabetBm[i]+".");
                else
                    System.out.print(Utils.alphabetBm[i]+",\t");
            }

            System.out.println();

            for(int i = 0; i<Utils.alphabetBm.length; i++){
                    System.out.print((i+1)+"\t");
            }

            System.out.print("\nС какой буквы начать сдвиг (укажите цифру): ");
            shift_ch = sc.hasNextInt() ? sc.nextInt() : -1;
            if (shift_ch == 0) {
                System.out.println("Выход из программы.");
                break;
            }

            while (shift_ch > Utils.alphabetSm.length + 1)//Вычисляю начальную позицию в алфавите
                shift_ch -= Utils.alphabetSm.length;

            str2 = str3 = "";
            if (shift_ch > 0) {
                for (char ch : str.toCharArray()) {
                    str2 += cipher(ch, shift_ch);//ищу символ относитьельно позиции в алфавите
                }
                for (char ch : str2.toCharArray()) {
                    str3 += reCipher(ch, shift_ch);
                }
                System.out.println("Сообщение: \t\t\t\t\t" + str);
                System.out.println("Зашифрованное сообщение: \t" + str2);
                System.out.println("Расшифровка: \t\t\t\t" + str3 +"\n");
                sc.nextLine();
            }
            else {
                System.out.println("Неверно указан номер сдвига!");
                sc.nextLine();
            }
        }
    }
    private static char cipher(char symbol, int position){
        for(int i = 0; i < Utils.alphabetSm.length; i++) {
            if (symbol == Utils.alphabetSm[i]) {//для строчных
                if (i + position - 1 > Utils.alphabetSm.length - 1)
                    return Utils.alphabetSm[i + position - 1 - Utils.alphabetSm.length];//позиция символа выходит за границы алфавита
                else
                    return Utils.alphabetSm[i + position - 1];//не выходит за границы
            } else if(symbol == Utils.alphabetBm[i]) {//для заглавных
                if (i + position - 1 > Utils.alphabetBm.length - 1)
                    return Utils.alphabetBm[i + position - 1 - Utils.alphabetBm.length];
                else
                    return Utils.alphabetBm[i + position - 1];
            }
        }
        return symbol;
    }

    private static char reCipher(char symbol, int position){
        for(int i = 0; i < Utils.alphabetSm.length; i++) {
            if (symbol == Utils.alphabetSm[i]) {
                if (i - (position - 1) < 0)
                    return Utils.alphabetSm[i - (position - 1) + Utils.alphabetSm.length];
                else
                    return Utils.alphabetSm[i - (position - 1)];
            } else if(symbol == Utils.alphabetBm[i]){
                if (i - (position - 1) < 0)
                    return Utils.alphabetBm[i - (position - 1) + Utils.alphabetBm.length];
                else
                    return Utils.alphabetBm[i - (position - 1)];
            }
        }
        return symbol;
    }
}
