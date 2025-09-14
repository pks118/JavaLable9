public class num5 {
    public static void main(String[] args) {
        String str = "hello world and always come back";
        int step = 0;
        for(int i =0; i<str.length();i++){
            step++;
            if(str.charAt(i)==' ' )
            {
                System.out.println(str.substring(i-(step-1),i));
                step=0;
            }
        }
        for (int i = str.length() - 1; i != 0; i--)
            if (str.charAt(i) == ' ') {
                System.out.println(str.substring(i+1));
                break;
            }
    }
}
