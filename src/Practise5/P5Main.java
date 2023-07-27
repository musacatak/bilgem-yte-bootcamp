package Practise5;
import java.util.*;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class P5Main {
    public static void main(String[] args) {



        List<String> stringList = new ArrayList<>(List.of("T.C. sanayi VE teknoloji BAKANLIĞI", "STB",
                "TÜBİTAK", "TÜBİTAK", "TÜBİTAK", "BilGEm", "YTE", "Yazılım", "yazılım",
                "YAZILIM", "     ", " ", "", "Teknolojileri", "Araştırma", "Enstitüsü", "java", "stream"));


        //stringList.stream().distinct().filter(value -> value != null).map(String::toUpperCase)
        //       .sorted(Collections.reverseOrder()).collect(Collectors.toList());

        List<String> resultList = stringList.stream()
                .map(String::toUpperCase)
                .filter(s -> s != null && !s.isEmpty() && s.contains("A"))
                .distinct()
                .sorted(Collections.reverseOrder()) // Descending sort
                .collect(Collectors.toList());


        resultList.stream().forEach(System.out::println);



    }






}

