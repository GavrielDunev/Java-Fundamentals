import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"stop".equals(input)) {
            int quantity = Integer.parseInt(scanner.nextLine());
            resources.putIfAbsent(input, 0);
            int currentQuantity = resources.get(input);
            resources.put(input, currentQuantity + quantity);
            input = scanner.nextLine();
        }
        resources.forEach((k, v) -> System.out.printf("%s -> %d%n", k, v));
    }
}
