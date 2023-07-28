package Practise4;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class P4Main {
    public static void main(String[] args) throws MyException {
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        if (input > 100) {
            throw new MyException(input + " sayısı 100'den büyük");
        }

    }
}

// A Class that represents use-defined exception


