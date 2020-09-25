import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(e -> Double.parseDouble(e))
                .toArray();

        Map<Double, Integer> counts = new TreeMap<>();
        for (double number : numbers) {
            if (counts.containsKey(number)) {
                int currentValue = counts.get(number);
                counts.put(number, currentValue + 1);
            } else {
                counts.put(number, 1);
            }
        }
        DecimalFormat decimalFormat = new DecimalFormat("#.#######");
        for (Map.Entry<Double, Integer> entry : counts.entrySet()) {
            System.out.printf("%s -> %d%n", decimalFormat.format(entry.getKey()), entry.getValue());
        }
    }
}
