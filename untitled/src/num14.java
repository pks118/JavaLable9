import java.util.Scanner;

public class num14 {
    public static void main(String[] args) {
        int wordStart = 0, numWords = 0;
        String str = "   wasdw     dwawd        dwawd    wdd", restOfWord, result = "", spaces = "";
        for(int i = 0; i < str.length(); i++) {//Считаю слова в строке
            if (i != str.length()-1) {
                if ((str.charAt(i) != ' ' && str.charAt(i + 1) == ' ')) {
                    numWords++;
                }
            }
            else if(str.charAt(i) != ' ')
                numWords++;
        }
        for(int i = 0; i < str.length(); i++) {//генерирую пробелы
            if (str.charAt(i) == ' ')
                spaces+= " ";
        }
        if(numWords > 0)
            spaces = spaces.substring(0, spaces.length()-numWords+1);
        for (int i = 0, shet = 0; i <= str.length(); i++) {//привожу строчку к одному формату
            if (i == str.length() || str.charAt(i) == ' ' ) {
                shet++;
                if (i == str.length() || (wordStart < i )&&str.charAt(i+1) == ' ') {
                    restOfWord = str.substring(wordStart, i);
                    if(i == str.length())
                        result += restOfWord;
                    else
                        result += restOfWord + " ";
                    shet = 0;
                }
                wordStart = i + 1;
            }
        }
        if(result.charAt(result.length()-1) == ' ')
            result = result.substring(0, result.length()-1);
        System.out.println("Выберите пункт меню:\n1. Выравнивание по левому краю;\n2. Выравнивание по правому краю;\n3. Выравнивание по центру;\n4. Выравнивание по ширине.");
        Scanner sc = new Scanner(System.in);
        int hudMenu = sc.nextInt();
        boolean flag = true;
        switch (hudMenu){
            case 1:
                result = result + spaces ;//Добавляю пробелы
                break;
            case 2:
                result = spaces + result;
                break;
            case 3:
                spaces = spaces.substring(0, (spaces.length()/2));
                result = spaces + result + spaces;
                for (int i = 0; i < str.length() - result.length(); i++){//заполняю остаток
                    result += " ";
                }
                break;
            case 4:
                result ="";
                double addSpaces = (((double) (spaces.length() + numWords - 1) % (numWords-1))); //подсчитываю количество оставшихся пробелов
                spaces = spaces.substring(0, ((spaces.length()+numWords-1)/(numWords-1)));//считаю пробелы
                for (int i = 0, shet = 0, shet2 = 0; i <= str.length(); i++) {
                    if (i == str.length() || str.charAt(i) == ' ' ) {
                        shet++;
                        if (i == str.length() || (wordStart < i )&&str.charAt(i+1) == ' ') {
                            restOfWord = str.substring(wordStart, i);
                            if(i == str.length())
                                result += restOfWord;
                            else if(shet2 != (int)addSpaces) {
                                result += restOfWord + spaces + " ";
                                shet2++;
                            }
                            else
                                result += restOfWord + spaces;
                            shet = 0;
                        }
                        wordStart = i + 1;
                    }
                }
                break;
            default:
                System.out.println("Ошибка");
                flag = false;
                break;
        }
        if(flag){
            System.out.println("["+result+"]");
            System.out.println("Количество символов до изменения: "+str.length());
            System.out.println("После: "+result.length());
        }
    }
}
