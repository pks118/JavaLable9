public class num6 {
    public static void main(String[] args) {
        int shiftCh = 10;
        String str = "Gfresef fesee troier rifjri", str2 = "";
        boolean flag = str.length() != 0;
        if (flag) {
            for (char ch : str.toCharArray()) {
                System.out.println(ch + " " + (char) (ch - shiftCh));
                str2 += (char) (ch - shiftCh);
            }
            System.out.println(str2);
            str = "";
            for (char ch : str2.toCharArray()) {
                System.out.println(ch + " " + (char) (ch + shiftCh));
                str += (char) (ch + shiftCh);
            }
            System.out.println(str);
        }
    }
}
