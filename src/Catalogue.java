import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import static java.util.Comparator.comparingDouble;
import static java.util.Comparator.comparingInt;
public class Catalogue extends  Product{

    public Catalogue(String name, String type, int id, double weight, long price) {
        super(name, type, id, weight, price);
    }

    public static @NotNull
    List<Product> loadInventory() {
        List<Product> catalogue = new ArrayList<>();

        try (InputStream inputStream = Catalogue.class.getResourceAsStream("/database.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String type = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                Product product = new Product(id, name, type, price, quantity);
                catalogue.add(product);
            }
        } catch ( IOException e) {
            System.err.println("Error reading database.txt file: " + e.getMessage());
        }

        return catalogue;
    }


    public static void listProducts(List<Product> catalogue) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter sort order (ID, name, category, price, or quantity): ");
        String order = scanner.nextLine().trim().toLowerCase();
        List<Product> sorted = new ArrayList<>(catalogue);
        switch (order) {
            case "id":
                Collections.sort(sorted, comparingInt(Product::getId));
                break;
            case "name":
                Collections.sort(sorted, Comparator.comparing(Product::getName));
                break;
            case "type":
                Collections.sort(sorted, Comparator.comparing(Product::getType));
                break;
            case "price":
                Collections.sort(sorted, Comparator.comparingDouble(Product::getPrice));
                break;
            case "weight":
                Collections.sort(sorted, comparingDouble(Product::getWeight));
                break;
            default:
                System.out.println("Invalid sort order.");
                return;
        }
        System.out.println("Product list:");
        for (Product product : sorted) {
            System.out.println(product);
        }
    }


    public static void searchProducts(List<Product> catalogue) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter search parameter (ID, name, category, price, or quantity): ");
        String parameter = scanner.nextLine().trim().toLowerCase();
        System.out.print("Enter search value: ");
        String value = scanner.nextLine().trim().toLowerCase();
        List<Product> results = new ArrayList<>();
        for (Product product : catalogue) {
            switch (parameter) {
                case "id":
                    if (product.getId() == Integer.parseInt(value)) {
                        results.add(product);
                    }
                    break;
                case "name":
                    if (product.getName().toLowerCase().contains(value)) {
                        results.add(product);
                    }
                    break;
                case "type":
                    if (product.getType().toLowerCase().contains(value)) {
                        results.add(product);
                    }
                    break;
                case "price":
                    if (product.getPrice() == Double.parseDouble(value)) {
                        results.add(product);
                    }
                    break;
                case "weight":
                    if (product.getWeight() == Integer.parseInt(value)) {
                        results.add(product);
                    }
                    break;
                default:
                    System.out.println("Invalid search parameter.");
                    return;
            }
        }
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        for (Product product : results) {
            System.out.println(product);
        }
    }
}
