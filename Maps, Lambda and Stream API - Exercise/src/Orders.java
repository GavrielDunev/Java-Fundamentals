import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> productsPrice = new LinkedHashMap<>();
        Map<String, Integer> productsQuantity = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!"buy".equals(input)) {
            String[] tokens = input.split(" ");
            String currentProduct = tokens[0];
            double price = Double.parseDouble(tokens[1]);
            int quantity = Integer.parseInt(tokens[2]);
            productsPrice.put(currentProduct, price);
            productsQuantity.putIfAbsent(currentProduct, 0);
            int currentQuantity = productsQuantity.get(currentProduct);
            productsQuantity.put(currentProduct, quantity + currentQuantity);

            input = scanner.nextLine();
        }
        productsPrice.forEach((k, v) -> System.out.println(String.format("%s -> %.2f", k, v * productsQuantity.get(k))));
    }
}
