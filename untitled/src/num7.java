import java.util.Scanner;

public class num7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str, str1;

        String[] symbolKyr = {"а", "б", "к", "д", "е", "ф", "г", "х", "и", "дж", "к", "л", "м", "н", "о", "п", "ку", "р", "с", "т", "у", "в", "в", "кс", "ай", "з",
                              "А", "Б", "К", "Д", "Е", "Ф", "Г", "Х", "И", "Дж", "К", "Л", "М", "Н", "О", "П", "Ку", "Р", "С", "Т", "У", "В", "В", "Кс", "ай", "З"};
        String[] symbolLat = {"a", "b", "v", "g", "d", "e", "jo", "j", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "т", "u", "f", "h", "c", "ch", "sh", "sh'", "", "i", "'", "a", "ju", "ya",
                              "A", "B", "V", "G", "D", "E", "Jo", "J", "Z", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "C", "Ch", "Sh", "Sh'", "I", "A", "Ju", "Ya"};
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
                        ? fromLatinToKirill(str.charAt(i), symbolKyr)//транслитизатор латиницы в кириллицу
                        : fromKirillToLatin(str.charAt(i), symbolLat);
            System.out.println(str1);
        }
    }
    private static String fromLatinToKirill(char symbol, String[] symbolKyr) {
        String str = "";
        str += symbol;
        for (int i = 0; i < Utils.alphLat.length(); i++)
            if (symbol == Utils.alphLat.charAt(i))
                return symbolKyr[i];
        return str;
    }

    private static String fromKirillToLatin(char symbol, String[] symbolLat) {
        String str = "";
        str += symbol;
        for (int i = 0; i < Utils.alphKir.length(); i++)
            if (symbol == Utils.alphKir.charAt(i))
                return symbolLat[i];
        return str;
    }
}
