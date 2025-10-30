import java.util.Scanner;

public class num6 {
    final static char [] alphabetSm = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    final static char [] alphabetBm = {'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int shift_ch = -1;
        String str;
        String str2 = "";
        String str3 = "";
        boolean flag;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            System.out.println("Алфавит");
            for(int i = 0; i<alphabetBm.length; i++){
                if(i == alphabetBm.length-1)
                    System.out.print(alphabetBm[i]+".");
                else
                    System.out.print(alphabetBm[i]+",\t");
            }
            System.out.println();
            for(int i = 0; i<alphabetBm.length; i++){
                    System.out.print((i+1)+"\t");
            }
            System.out.println();
            System.out.print("С какой буквы начать сдвиг (укажите цифру): ");
            if(sc.hasNextInt())
                shift_ch = sc.nextInt();
            else shift_ch=-1;

            if (shift_ch == 0) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() > 0 && shift_ch > 0;
            while (shift_ch > alphabetSm.length + 1)//Вычисляю начальную позицию в алфавите
                shift_ch -= alphabetSm.length;
            if (flag) {
                for (char ch : str.toCharArray()) {
                    str2 += cipher(ch, shift_ch);//ищу символ относитьельно позиции в алфавите
                }
                for (char ch : str2.toCharArray()) {
                    str3 += reCipher(ch, shift_ch);
                }
                System.out.println("Сообщение: \t\t\t\t\t" + str);
                System.out.println("Зашифрованное сообщение: \t" + str2);
                System.out.println("Расшифровка: \t\t\t\t" + str3 +"\n");
                str2="";
                str3="";
                sc.nextLine();//я не знаю почему, но после ввода целого числа скан пропускает ввод строчки. Повторный ввод это чинит
            }
            else {
                System.out.println("Был замечан не верный паттерн ввода! Убедительная просьба ввести данные повторно!");
                str2="";
                str3="";
                sc.nextLine();
            }
        }
    }
    public static char cipher(char symbol, int position){
        for(int i = 0; i < alphabetSm.length; i++) {
            if (symbol == alphabetSm[i]) {//для строчных
                if (i + position - 1 > alphabetSm.length - 1)
                    return alphabetSm[i + position - 1 - alphabetSm.length];//позиция символа выходит за границы алфавита
                else
                    return alphabetSm[i + position - 1];//не выходит за границы
            } else if(symbol == alphabetBm[i]) {//для заглавных
                if (i + position - 1 > alphabetBm.length - 1)
                    return alphabetBm[i + position - 1 - alphabetBm.length];
                else
                    return alphabetBm[i + position - 1];
            }
        }
        return symbol;//символа нет в алфавите
    }
    public static char reCipher(char symbol, int position){
        for(int i = 0; i < alphabetSm.length; i++) {
            if (symbol == alphabetSm[i]) {
                if (i - (position - 1) < 0)
                    return alphabetSm[i - (position - 1) + alphabetSm.length];
                else
                    return alphabetSm[i - (position - 1)];
            } else if(symbol == alphabetBm[i]){
                if (i - (position - 1) < 0)
                    return alphabetBm[i - (position - 1) + alphabetBm.length];
                else
                    return alphabetBm[i - (position - 1)];
            }
        }
        return symbol;
    }
}
