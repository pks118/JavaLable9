public class num5 {
    public static void main(String[] args) {
        String str = "Gfresef///// fesee /////troier //////   rifjri";
        boolean flag = str.length() != 0;
        int wordStart = 0;
        if(flag) {
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i)<= 47)|| (str.charAt(i) >= 58 && str.charAt(i)<= 64)|| (str.charAt(i) >= 91 && str.charAt(i)<= 96))) {
                    if (wordStart < i)
                        System.out.println(str.substring(wordStart, i));
                    wordStart = i + 1;
                }
            }
        }
    }
}
