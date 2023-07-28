package Practise8;
import java.util.List;

public class Product {

    private String name;
    private String category;
    private double price;
    private List<String> subCategories;

    public Product(String name, String category, List<String> subCategories,double price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<String> subCategories) {
        this.subCategories = subCategories;
    }
}
