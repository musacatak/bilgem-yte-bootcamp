package Practise3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class P3Main {
    public static void main(String[] args) throws IOException {
        // Enter data using BufferReader

        System.out.println("--- Doğum Günü Tebrik Programı ---" + "\n"
                + "Doğum gününüzü ve saatinizi girin (örn. 2000-09-15 13:30): ");
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        LocalDateTime today = LocalDateTime.now();
        str = today.getYear() + str.substring(4);
        //System.out.println(str);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime userBD = LocalDateTime.parse(str, formatter);


        // implement 2 condition to dont do 12 - month
        long month = userBD.until(today, ChronoUnit.MONTHS);
        long day = userBD.until(today, ChronoUnit.DAYS);
        long hour = userBD.until(today, ChronoUnit.HOURS);
        long minute = userBD.until(today, ChronoUnit.MINUTES);

        System.out.println("Doğum gününüze " + (12 - month) + " ay, "+ (30 - day%30) + " gün, "  +
                (24 - hour%24) + " saat, " + (60 -minute%60) + " dakika kaldı.") ;
    }
}