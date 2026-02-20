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
