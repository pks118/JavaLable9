public class num11 {
    public static void main(String[] args) {
        int lendthSize = 100;
        String str = "wasdw dwawd dwawd wdd";
        boolean flag = str.length() != 0;
        if (flag) {
            int sizeStr = lendthSize - str.length();
            String spaces = "";

            for (int i = 0; i < sizeStr; i++) {
                spaces += " ";
            }
            String result = spaces + str;
            System.out.println(result);
        }
    }
}
