public class num12 {
    public static void main(String[] args) {
        int wordStart = 0, countWords = 0;
        //Scanner sc = new Scanner(System.in);
        //int lendthSize = sc.nextInt();
        String str = "wadw   wdawdw    awdawdd", restOfWord;
        wordStart = 0;
        int shet = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || (str.charAt(i) == ' ' && str.charAt(i+1) != ' ')) {
                shet++;
                if (wordStart < i) {
                    restOfWord = str.substring(wordStart, i);
                    System.out.println(restOfWord);
                }
                wordStart = i + 1;
            }

        }


    }
}
