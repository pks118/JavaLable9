import java.util.Scanner;

public class num7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, str1;

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

            str1 = "";
            for (int i = 0; i < str.length(); i++)
                str1 += Utils.alphLat.indexOf(str.charAt(i)) != -1
                        ? fromLatinToKirill(str.charAt(i), "абсдефгчижклмнопкрстувдсёзАБСДЕФГЧИЖКЛМНОПКРСТУВДСЁЗ")//транслитизатор латиницы в кириллицу
                        : fromKirillToLatin(str.charAt(i), "abvgdeyjziiklmnoprstufhchhh i ayiABVGDEYJZIIKLMNOPRSTUFHCHHH I AYI");
            System.out.println(str1);
        }
    }

    private static char fromLatinToKirill(char symbol, String symbolKyr) {
        return Utils.alphLat.indexOf(symbol) !=-1 ? symbolKyr.charAt(Utils.alphLat.indexOf(symbol)) : symbol;
    }

    private static char fromKirillToLatin(char symbol, String symbolLat) {
        return Utils.alphKir.indexOf(symbol) !=-1 ? symbolLat.charAt(Utils.alphKir.indexOf(symbol)) : symbol;
    }
}
