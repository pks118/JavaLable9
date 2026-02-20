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
    final static String alphLat = "abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
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
    final static char [] alphabetSm = {'а','б','в','г','д','е','ё','ж','з','и','й','к','л','м','н','о','п','р','с','т','у','ф','х','ц','ч','ш','щ','ъ','ы','ь','э','ю','я'};
    final static char [] alphabetBm = {'А','Б','В','Г','Д','Е','Ё','Ж','З','И','Й','К','Л','М','Н','О','П','Р','С','Т','У','Ф','Х','Ц','Ч','Ш','Щ','Ъ','Ы','Ь','Э','Ю','Я'};
}
