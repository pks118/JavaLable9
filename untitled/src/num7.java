import java.util.Scanner;

public class num7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str;
        String str1 = "";
        boolean flag;
        char[] symbolsLat = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
                'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        String[] symbolKyr = {"а", "б", "к", "д", "е", "ф", "г", "х", "и", "дж", "к", "л", "м", "н", "о", "п", "ку", "р", "с", "т", "у", "в", "в", "кс", "йе", "з",
                "А", "Б", "К", "Д", "Е", "Ф", "Г", "Х", "И", "Дж", "К", "Л", "М", "Н", "О", "П", "Ку", "Р", "С", "Т", "У", "В", "В", "Кс", "Йе", "З"};
        char[] symbolsKir = {'а', 'б', 'в', 'г', 'д', 'е', 'ё', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у', 'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ы', 'э', 'ю', 'я',
                'А', 'Б', 'В', 'Г', 'Д', 'Е', 'Ё', 'Ж', 'З', 'И', 'Й', 'К', 'Л', 'М', 'Н', 'О', 'П', 'Р', 'С', 'Т', 'У', 'Ф', 'Х', 'Ц', 'Ч', 'Ш', 'Щ', 'Ы', 'Э', 'Ю', 'Я'};
        String[] symbolLat = {"a", "b", "v", "g", "d", "e", "jo", "j", "z", "i", "jo", "k", "l", "m", "n", "o", "p", "r", "s", "т", "u", "f", "h", "c", "ch", "sh", "sh'", "i", "a", "ju", "ya",
                "A", "B", "V", "G", "D", "E", "Jo", "J", "Z", "I", "Jo", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "C", "Ch", "Sh", "Sh'", "I", "A", "Ju", "Ya"};
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();//строчка
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }
            flag = str.length() > 0;
            if (flag) {
                for (int i = 0; i < str.length(); i++)
                    if (str.charAt(i) >= 65 && str.charAt(i) <= 122)
                        str1 += fromLatinToKirill(str.charAt(i), symbolsLat, symbolKyr);//транслитизатор латиницы в кириллицу
                    else str1 += fromKirillToLatin(str.charAt(i), symbolsKir, symbolLat);//наоборот
                System.out.println(str1);
            } else { System.out.println("Был замечан не верный паттерн ввода! Убедительная просьба ввести данные повторно!");}
        }
    }
    private static String fromLatinToKirill(char symbol, char [] symbolsLat, String [] symbolKyr) {
        String str = "";
        str += symbol;
        for (int i = 0; i < symbolsLat.length; i++)
            if (symbol == symbolsLat[i])
                return symbolKyr[i];
        return str;
    }

    private static String fromKirillToLatin(char symbol, char [] symbolsKir, String [] symbolLat) {
        String str = "";
        str += symbol;
        for (int i = 0; i < symbolsKir.length; i++)
            if (symbol == symbolsKir[i])
                return symbolLat[i];
        return str;
    }
}
