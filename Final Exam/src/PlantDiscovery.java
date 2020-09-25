import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class PlantDiscovery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Double> rating = new LinkedHashMap<>();
        Map<String, Integer> rarity = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("<->");
            String plant = input[0];
            int rarityToBeAdded = Integer.parseInt(input[1]);
            rarity.put(plant, rarityToBeAdded);
            rating.put(plant, 0.0);
        }
        String[] input = scanner.nextLine().split(": ");
        while (!"Exhibition".equals(input[0])) {
            String currCommand = input[0];
            switch (currCommand) {
                case "Rate":
                    String[] plantNameAndDigit = input[1].split(" - ");
                    String plantName = plantNameAndDigit[0];
                    if (rating.containsKey(plantName)) {
                        double ratingToBeAdded = Double.parseDouble(plantNameAndDigit[1]);
                        if (rating.get(plantName) == 0.0) {
                            rating.put(plantName, ratingToBeAdded);
                        } else {
                            rating.put(plantName, (rating.get(plantName) + ratingToBeAdded) / 2);
                        }
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Update":
                    plantNameAndDigit = input[1].split(" - ");
                    plantName = plantNameAndDigit[0];
                    if (rarity.containsKey(plantName)) {
                        int newRarity = Integer.parseInt(plantNameAndDigit[1]);
                        rarity.put(plantName, newRarity);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "Reset":
                    plantNameAndDigit = input[1].split(" - ");
                    plantName = plantNameAndDigit[0];
                    if (rating.containsKey(plantName)) {
                        rating.put(plantName, 0.00);
                    } else {
                        System.out.println("error");
                    }
                    break;
                default:
                    System.out.println("error");
                    break;
            }
            input = scanner.nextLine().split(": ");
        }
        System.out.printf("Plants for the exhibition:%n");
        rarity.entrySet()
                .stream()
                .sorted((p1, p2) -> {
                    int result = p2.getValue().compareTo(p1.getValue());
                    if (result == 0) {
                        result = rating.get(p2.getKey()).compareTo(rating.get(p1.getKey()));
                    }
                    return result;
                })
                .forEach(entry -> System.out.printf("- %s; Rarity: %d; Rating: %.2f%n", entry.getKey(), entry.getValue(), rating.get(entry.getKey())));
    }
}