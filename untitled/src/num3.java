public class num3 {
    public static void main(String[] args) {
        int countSp = 0;
        String str = "Esfuseh eufhuesi ..... sefeu uhsuehfus";
        int lendthSize = 100;

        boolean flag = str.length() != 0;
        int countSym = 0;
        for (char ch : str.toCharArray())
            if(ch != ' ') {
                countSym++;
                break;
            }

        int  countWords = 0;
        int wordStart = 0;
        int totalWordSym = 0; //длина слов
        if(flag && countSym > 0) {
            for (int i = 0; i <= str.length(); i++) {
                if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i)<= 47)|| (str.charAt(i) >= 58 && str.charAt(i)<= 64)|| (str.charAt(i) >= 91 && str.charAt(i)<= 96))) {
                    if (wordStart < i) {
                        countWords++;
                        totalWordSym += (i - wordStart);
                        System.out.println("Слово: " + str.substring(wordStart, i));
                    }
                    wordStart = i + 1;
                }
            }

            String result = "";
            if(countWords > 1) {
                int baseSpaces = ((lendthSize - totalWordSym+(countWords-1))/2) - (countWords-1);
                int addSpaces = (lendthSize - totalWordSym) % 2;
                System.out.println("Общее количество пробелов: " + baseSpaces);
                System.out.println("Остаток пробелов: " + addSpaces);
                String spaces = "";
                for (int i = 0; i < baseSpaces; i++) {
                    spaces += " ";
                }

                System.out.println();

                wordStart = 0;
                int shet = 0;
                String restOfWord = "";
                for (int i = 0; i <= str.length(); i++) {
                    if (i == str.length() || ((str.charAt(i) >= 32 && str.charAt(i)<= 47)|| (str.charAt(i) >= 58 && str.charAt(i)<= 64)|| (str.charAt(i) >= 91 && str.charAt(i)<= 96))) {
                        if (wordStart < i) {
                            restOfWord = str.substring(wordStart, i);
                            result += restOfWord;
                            if (shet < countWords - 1) {
                                result += " ";
                            }
                            shet++;
                        }
                        wordStart = i + 1;
                    }
                }
                result = spaces + result + spaces;
            }
            System.out.println("Исходная строчка: ["+str+']');
            System.out.println("Длина исходной строчки: "+str.length()+"\n");
            System.out.println("Итоговоая строчка: ["+ result + ']');
            System.out.println("Длина итоговой строчки: "+result.length());
            System.out.println("Необходимая длина: " + lendthSize);
        }
    }
}
