public class num4 {
    public static void main(String[] args) {
        String str = "hello world and always come back", str2, str3 = "";
        char ch;
        int stage = 0;
        for (int i = 0; i < str.length(); i++) {
            stage++;
            if (str.charAt(i) == ' ') {
                ch = (char) ((int) (str.charAt(i - (stage - 1))) - 32);
                str2 = str.substring(1 + i - (stage - 1), i + 1);
                str3 += ch + str2;
                stage = 0;
            }
        }
        for (int i = str.length() - 1; i != 0; i--)
            if (str.charAt(i) == ' ') {
                ch = (char) ((int) (str.charAt(i + 1)) - 32);
                str2 = str.substring(i + 2);
                str3 += ch + str2;
                break;
            }
        System.out.println(str3);
    }
}
