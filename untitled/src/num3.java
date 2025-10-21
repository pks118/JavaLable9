public class num3 {
    public static void main(String[] args) {
        int countSp = 0;
        String str = "Esfuseh eufhuesi sefeu uhsuehfus", str2 = "";

        boolean flag = str.length() != 0;
        if(flag) {
            for (char ch : str.toCharArray())
                if (ch == ' ')
                    countSp++;
            int leftRightSp = countSp / 2;
            for (int i = 0; i < leftRightSp; i++) {
                str2 += " ";
            }
            str2 += str;
            for (int i = 0; i < leftRightSp; i++) {
                str2 += " ";
            }
            System.out.println(str2);
        }
    }
}
