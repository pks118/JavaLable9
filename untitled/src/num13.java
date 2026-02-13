import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class num13 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        String str;//строчка ввода
        int glass, soglas;
        System.out.println("Для выхода введите '0' ");
        while (true) {
            System.out.print("Введите строку: ");
            str = sc.nextLine();
            if (str.equals("0")) {
                System.out.println("Выход из программы.");
                break;
            }

            if (Utils.emptyStr(str)) {
                System.out.println("Строчка пуста!");
                continue;
            }

            if (Utils.onlySpaces(str)) {
                System.out.println("В строчке только пробелы!");
                continue;
            }

            glass = soglas = 0;
            for (char ch : str.toCharArray()) {
                if (ch >= 192 && ch != 'ь' && ch != 'ъ' && ch != 'Ь' && ch != 'Ъ') {
                    switch (ch) {
                        case 'а', 'о', 'у', 'и', 'ы', 'я', 'ю', 'е', 'ё', 'э', 'А', 'О', 'У', 'И', 'Ы', 'Я', 'Ю', 'Е', 'Ё', 'Э' ->
                                glass++;
                        default -> soglas++;
                    }
                } else if ((ch >= 65 && ch <= 90) || (ch >= 97 && ch <= 122)) {
                    switch (ch) {
                        case 'a', 'e', 'i', 'o', 'u', 'y', 'A', 'E', 'I', 'O', 'U', 'Y' -> glass++;
                        default -> soglas++;
                    }
                }
            }
            System.out.println("В строчке: "+str);
            System.out.println("Гласных: " + glass);
            System.out.println("Согласных: " + soglas);
        }
    }
}
