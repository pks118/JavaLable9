public class Utils {
    public static boolean onlySpaces(String str) {
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) != ' ') {
                return false;
            }

        return true;
    }

    public static boolean emptyStr(String str) {
        return str.length() == 0;
    }

    final static String alphLat = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    final static String alphKir = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЭЮЯ";
    final static String[] translitLatArray = {"a", "b", "v", "g", "d", "e", "jo", "j", "z", "i", "j", "k", "l", "m", "n", "o", "p", "r", "s", "т", "u", "f", "h", "c", "ch", "sh", "sh'", "", "i", "'", "a", "ju", "ya",
            "A", "B", "V", "G", "D", "E", "Jo", "J", "Z", "I", "J", "K", "L", "M", "N", "O", "P", "R", "S", "T", "U", "F", "H", "C", "Ch", "Sh", "Sh'", "I", "A", "Ju", "Ya"};

    public static String transliter(char symbol) {
        String str = "" + symbol;
        if (alphKir.indexOf(symbol) != -1)
            return translitLatArray[alphKir.indexOf(symbol)];
        else return str;
    }

    public static boolean checkAlpha(char sym) {
        return alphLat.indexOf(sym) != -1 || alphKir.indexOf(sym) != -1;
    }

    public static char toUpperCase(char c) {
        if (c >= 'а' && c <= 'я') {
            return (char) (c - 32);
        } else if (c == 'ё') {//Исключаю Ё
            return 'Ё';
        } else if (c >= 'a' && c <= 'z') {
            return (char) (c - 32);
        }
        return c;
    }
}
