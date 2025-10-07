public class num12 {
    public static void main(String[] args) {
        int wordStart = 0;

        String str = "wadw        wdawdw    awdawdd", restOfWord, result = "";
        int shet = 0;
        for (int i = 0; i <= str.length(); i++) {
            if (i == str.length() || str.charAt(i) == ' ' ) {
                shet++;
                if (i == str.length() || (wordStart < i )&&str.charAt(i+1) == ' ') {
                    System.out.println(shet);
                    restOfWord = str.substring(wordStart, i);
                    if(i == str.length())
                        result += restOfWord;
                    else
                        result += restOfWord + " ";
                    shet = 0;
                    System.out.println(restOfWord);
                }
                wordStart = i + 1;
            }

        }
        System.out.println(result);


    }
}
