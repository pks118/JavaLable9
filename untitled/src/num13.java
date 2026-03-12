import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class num13 {
    public static void main(String[] args) { /// tydtydytke6u
        Scanner sc = new Scanner(System.in);
        String str;
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
            String glassesKir = "аоуиыяюуёэАОУИЫЯЮЕЁЭ";
            String glassesLat = "aeiouyAEIOUY";
            for (int i = 0; i < str.length(); i++) {
                if ((Utils.alphKir.indexOf(str.charAt(i)) != -1 && glassesKir.indexOf(str.charAt(i)) != -1) ||
                    (Utils.alphLat.indexOf(str.charAt(i)) != -1 && glassesLat.indexOf(str.charAt(i)) != -1))
                    glass++;
                else
                    soglas++;
            }
            System.out.println("В строчке: " + str);
            System.out.println("Гласных: " + glass);
            System.out.println("Согласных: " + soglas);
        }
    }
}
