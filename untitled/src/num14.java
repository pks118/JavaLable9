import java.util.Scanner;

public class num14 {
    public static void main(String[] args) {
        int wordStart = 0, numWords = 0;
        String str = "   wdawd       dwwrgtht  dfse    ", restOfWord, result = "", spaces = "";
        boolean strTrue = str.length() != 0;
        if (strTrue) {
            //Считаю слова в строке
            for (int i = 0; i < str.length(); i++) {
                if (i != str.length() - 1) {
                    if ((str.charAt(i) != ' ' && str.charAt(i + 1) == ' ')) {
                        numWords++;
                    }
                } else if (str.charAt(i) != ' ')
                    numWords++;
            }

            //генерирую пробелы
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == ' ')
                    spaces += " ";
            }
            if (numWords > 0)
                spaces = spaces.substring(0, spaces.length() - numWords + 1);
            //привожу строчку к одному формату
            //удаляю все лишние пробелы в строчке
            for (int i = 0, shet = 0; i <= str.length(); i++) {
                if (i == str.length() || str.charAt(i) == ' ') {
                    shet++;
                    if (i == str.length() || (wordStart < i) && str.charAt(i + 1) == ' ') {
                        restOfWord = str.substring(wordStart, i);
                        if (i == str.length())
                            result += restOfWord;
                        else
                            result += restOfWord + " ";
                        shet = 0;
                    }
                    wordStart = i + 1;
                }
            }
            if (result.charAt(result.length() - 1) == ' ')
                result = result.substring(0, result.length() - 1);


            System.out.println("Выберите пункт меню:\n1. Выравнивание по левому краю;\n2. Выравнивание по правому краю;\n3. Выравнивание по центру;\n4. Выравнивание по ширине.");

            Scanner sc = new Scanner(System.in);
            int hudMenu = sc.nextInt();
            boolean flag = true;
            switch (hudMenu) {
                case 1:
                    //Добавляю пробелы
                    result = result + spaces;
                    break;
                case 2:
                    result = spaces + result;
                    break;
                case 3:
                    spaces = spaces.substring(0, (spaces.length() / 2));
                    result = spaces + result + spaces;
                    //заполняю остаток
                    for (int i = 0; i < str.length() - result.length(); i++) {
                        result += " ";
                    }
                    break;
                case 4:
                    result = "";
                    //подсчитываю количество оставшихся пробелов
                    double addSpaces = (((double) (spaces.length() + numWords - 1) / (numWords - 1)) - (spaces.length() + numWords - 1) / (numWords - 1)) * (numWords - 1);
                    System.out.println(addSpaces);
                    //считаю пробелы
                    spaces = spaces.substring(0, ((spaces.length() + numWords - 1) / (numWords - 1)));
                    System.out.println(spaces.length());

                    for (int i = 0, shet = 0, shet2 = 0; i <= str.length(); i++) {
                        if (i == str.length() || str.charAt(i) == ' ') {
                            shet++;
                            if (i == str.length() || (wordStart < i) && str.charAt(i + 1) == ' ') {
                                restOfWord = str.substring(wordStart, i);
                                if (i == str.length())
                                    result += restOfWord;
                                else if (shet2 != (int) addSpaces) {
                                    result += restOfWord + spaces + " ";
                                    shet2++;
                                } else
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
            if (flag) {
                System.out.println("[" + result + "]");
                System.out.println("Количество символов до изменения: " + str.length());
                System.out.println("После: " + result.length());
            }
        }
    }
}
