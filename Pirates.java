import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Pirates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> population = new LinkedHashMap<>();
        Map<String, Integer> gold = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split("\\|\\|");
        while (!"Sail".equals(input[0])) {
            String city = input[0];
            int people = Integer.parseInt(input[1]);
            int money = Integer.parseInt(input[2]);
            if (!population.containsKey(city)) {
                population.put(city, people);
                gold.put(city, money);
            } else {
                int peopleToAdd = people + population.get(city);
                int moneyToAdd = money + gold.get(city);
                population.put(city, peopleToAdd);
                gold.put(city, moneyToAdd);
            }
            input = scanner.nextLine().split("\\|\\|");
        }
        input = scanner.nextLine().split("=>");
        while (!input[0].equals("End")) {
            String command = input[0];
            switch (command) {
                case "Plunder":
                    String city = input[1];
                    int people = Integer.parseInt(input[2]);
                    int money = Integer.parseInt(input[3]);
                    System.out.printf("%s plundered! %d gold stolen, %d citizens killed.%n", city, money, people);
                    population.put(city, population.get(city) - people);
                    gold.put(city, gold.get(city) - money);
                    if (population.get(city) == 0 || gold.get(city) == 0) {
                        population.remove(city);
                        gold.remove(city);
                        System.out.printf("%s has been wiped off the map!%n", city);
                    }
                    break;
                case "Prosper":
                    city = input[1];
                    money = Integer.parseInt(input[2]);
                    if (money < 0) {
                        System.out.println("Gold added cannot be a negative number!");
                    } else {
                        gold.put(city, gold.get(city) + money);
                        System.out.printf("%d gold added to the city treasury. %s now has %d gold.%n", money, city, gold.get(city));
                    }
                    break;
            }

            input = scanner.nextLine().split("=>");
        }
        if (population.size() != 0) {
            System.out.printf("Ahoy, Captain! There are %d wealthy settlements to go to:%n", population.size());
            gold.entrySet()
                    .stream()
                    .sorted((g1, g2) -> {
                        int result = g2.getValue().compareTo(g1.getValue());
                        if (result == 0) {
                            result = g1.getKey().compareTo(g2.getKey());
                        }
                        return result;
                    })
                    .forEach(e -> {
                        System.out.printf("%s -> Population: %d citizens, Gold: %d kg%n", e.getKey(), population.get(e.getKey()), e.getValue());
                    });
        } else {
            System.out.println("Ahoy, Captain! All targets have been plundered and destroyed!");
        }
    }
}
