import java.util.*;

public class NikuldensMeals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> guests = new HashMap<>();
        String[] tokens = scanner.nextLine().split("-");
        int count = 0;
        while (!"Stop".equals(tokens[0])) {
            String command = tokens[0];
            String currGuest = tokens[1];
            String currMeal = tokens[2];
            switch (command) {
                case "Like":
                    guests.putIfAbsent(currGuest, new ArrayList<>());
                    List<String> meals = guests.get(currGuest);
                    if (!meals.contains(currMeal)) {
                        meals.add(currMeal);
                        guests.put(currGuest, meals);
                    }
                    break;
                case "Unlike":
                    if (!guests.containsKey(currGuest)) {
                        System.out.printf("%s is not at the party.%n", currGuest);
                    } else if (!guests.get(currGuest).contains(currMeal)) {
                        System.out.printf("%s doesn't have the %s in his/her collection.%n", currGuest, currMeal);
                    } else {
                        meals = guests.get(currGuest);
                        meals.remove(currMeal);
                        guests.put(currGuest, meals);
                        System.out.printf("%s doesn't like the %s.%n", currGuest, currMeal);
                        count++;
                    }
                    break;
            }
            tokens = scanner.nextLine().split("-");
        }
        guests.entrySet()
                .stream()
                .sorted((g1, g2) -> {
                    int result = g2.getValue().size() - g1.getValue().size();
                    if (result == 0) {
                        result = g1.getKey().compareTo(g2.getKey());
                    }
                    return result;
                })
                .forEach(g -> System.out.println(g.getKey() + ": " + g.getValue().toString().replaceAll("[\\[\\]]", "")));
        System.out.printf("Unliked meals: %d", count);
    }
}