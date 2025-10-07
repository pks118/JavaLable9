import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class num13 {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "untitled\\src\\input.txt";
        Scanner sc = new Scanner(new File(path));
        int countStr = 0;
        List<String> strs = new ArrayList<>();

        while (sc.hasNextLine())
        {
            strs.add(sc.nextLine());
            countStr++;
        }
        sc.close();


        System.out.println("Дан файл: input.txt");
        int strNum = 1;
        for(String str : strs)
            System.out.println((strNum++) + "| " + str);


        System.out.println("Введите номер строки: ");
        sc = new Scanner(System.in);
        int sizeStr = sc.nextInt();


        if(countStr>=sizeStr){
            String str = strs.get(sizeStr-1);
            int glass = 0, soglas = 0;
            for (char ch : str.toCharArray()){
                if(ch >= 192 && ch != 'ь' && ch != 'ъ' && ch != 'Ь' && ch != 'Ъ') {
                    if (ch == 'а' || ch == 'о' || ch == 'у' || ch == 'и' || ch == 'ы' || ch == 'я'|| ch == 'ю'|| ch == 'е'|| ch == 'ё'|| ch == 'э' || ch == 'А' || ch == 'О' || ch == 'У' || ch == 'И' || ch == 'Ы' || ch == 'Я'|| ch == 'Ю'|| ch == 'Е'|| ch == 'Ё'|| ch == 'Э')
                        glass++;
                     else
                        soglas++;
                }
                else if((ch >= 65 && ch <= 90)||(ch >= 97 && ch <= 122)){
                    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y'|| ch == 'A'|| ch == 'E'|| ch == 'I'|| ch == 'O' || ch == 'U' || ch == 'Y')
                        glass++;
                    else
                        soglas++;
                }
            }
            System.out.println(strs.get(sizeStr-1));
            System.out.println("Гласных: "+glass);
            System.out.println("Согласных: "+soglas);
        }
        else
            System.out.println("Ошибка: строчка "+ sizeStr + " не существует!");

    }

}
