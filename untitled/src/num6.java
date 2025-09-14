public class num6 {
    public static void main(String[] args) {
        int shiftCh = 10;
        String str = "hello world and always come back", str2="";
        for (char ch : str.toCharArray()){
            System.out.println(ch + " " + (char)(ch-shiftCh));
            str2+= (char)(ch-shiftCh);
        }
        System.out.println(str2);
        str="";
        for (char ch : str2.toCharArray()){
            System.out.println(ch + " " + (char)(ch+shiftCh));
            str+= (char)(ch+shiftCh);
        }
        System.out.println(str);
    }
}
