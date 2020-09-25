import java.util.*;

public class OddOccurrences {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().toLowerCase().split(" ");
        Map<String, Integer> words = new LinkedHashMap<>();
        for (String s : input) {
            if (words.containsKey(s)) {
                int currentValue = words.get(s);
                words.put(s, currentValue + 1);
            } else {
                words.put(s, 1);
            }
        }
        List<String> oddOccurrences = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                oddOccurrences.add(entry.getKey());
            }
        }
        System.out.println(String.join(", ", oddOccurrences));
    }
}