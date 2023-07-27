package Practise8;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class P8Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", Arrays.asList("Computers", "Gaming"), 1200));
        products.add(new Product("Smartphone", "Electronics", Arrays.asList("Phones", "Accessories"), 800));
        products.add(new Product("Mouse", "Electronics", Arrays.asList("Peripherals", "Wireless"), 150));
        products.add(new Product("T-Shirt", "Fashion", Arrays.asList("Clothing", "Summer Wear"), 25));
        products.add(new Product("Sneakers", "Fashion", Arrays.asList("Shoes", "Running"), 80));
        products.add(new Product("Keyboard", "Electronics", Arrays.asList("Peripherals", "Wireless"), 150));
        products.add(new Product("Headphones", "Electronics", Arrays.asList("Audio", "Wireless"), 150));
        products.add(new Product("Dress", "Fashion", Arrays.asList("Clothing", "Summer Wear"), 45));
        products.add(new Product("Desktop PC", "Electronics", Arrays.asList("Computers", "Gaming"), 1000));
        products.add(new Product("Phone", "Electronics", Arrays.asList("Phones", "Accessories"), 800));

        List<String> uniqueSubcategories = products.stream()
                .flatMap(product -> product.getSubCategories().stream()).distinct().collect(Collectors.toList());

        System.out.println(uniqueSubcategories);

        //Concat does not accepted
        Map<String, List<String>> categoriesWithSubcategories = products.stream()
                .collect(Collectors.toMap(Product::getCategory, Product::getSubCategories,
                        (existingList, newList) -> {   // Merge function for handling duplicates from GPT
                            List<String> mergedList = new ArrayList<>(existingList);
                            mergedList.addAll(newList);
                            return mergedList.stream().distinct().collect(Collectors.toList());
                        }));

        System.out.println(categoriesWithSubcategories);
    }
}
