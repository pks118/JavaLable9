public class num5 {
    public static void main(String[] args) {
        String str = "hello world and always come back";
        int step = 0;
        for (int i = 0; i <= str.length(); i++) {
            step++;
            if (i == str.length() || str.charAt(i) == ' ') {
                System.out.println(str.substring(i - (step - 1), i));
                step = 0;
            }
        }

    }
}
