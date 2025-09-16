public class num10 {
    public static void main(String[] args) {
        String str = "12.13.3000";
        System.out.println(checkingEnteredDay(str.substring(6)));
    }
    private static int checkingEnteredDay (String nums)
    {
        int num = 0;
        for (int i = nums.length()-1; i>=0; i--)
            num += (nums.charAt(i) - 48) * ((int) Math.pow(10, (nums.length()-1)-i));
        return num;
    }
}
