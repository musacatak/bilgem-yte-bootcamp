package Practise6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class P6Main {
    public static void main(String[] args) {
        //- 5 9 pozitif ve çift her birinin karesini al topla

        List<Integer> numbers = new ArrayList<>(Arrays.asList(-5, -4, -3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        System.out.println(
                numbers.stream().filter(value -> value >= 0 && value % 2 == 0)
                        .map(i -> i * i).reduce(0, Integer::sum));


    }
}
