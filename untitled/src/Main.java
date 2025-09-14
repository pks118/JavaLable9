
public class Main {
    public static void main(String[] args) {
        String str = "         Hello World!         ";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                str = str.substring(i);
                break;
            }
        }
        for (int i = str.length() - 1; i != 0; i--) {
            if (str.charAt(i) != ' ') {
                str = str.substring(0, i);
                break;
            }
        }
        for (char c : str.toCharArray()) {
            System.out.print(c);
        }
    }
}