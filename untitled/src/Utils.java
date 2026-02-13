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
    public static boolean checkAlpha(char sym) {
        String alph = "abcdefghijklmnopqrstuvwxyzABCDEFGHJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < alph.length(); i++)
            if(alph.charAt(i) == sym)
                return true;
        // indexOf()
        return false;
    }
}
