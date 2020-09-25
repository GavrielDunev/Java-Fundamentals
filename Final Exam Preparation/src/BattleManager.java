import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class BattleManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> healthOfPeople = new TreeMap<>();
        Map<String, Integer> energyOfPeople = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split(":");
        while (!"Results".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "Add":
                    String personaName = input[1];
                    int health = Integer.parseInt(input[2]);
                    int energy = Integer.parseInt(input[3]);
                    if (healthOfPeople.containsKey(personaName)) {
                        healthOfPeople.put(personaName, healthOfPeople.get(personaName) + health);
                    } else {
                        healthOfPeople.put(personaName, health);
                        energyOfPeople.put(personaName, energy);
                    }
                    break;
                case "Attack":
                    String attacker = input[1];
                    String defender = input[2];
                    int damage = Integer.parseInt(input[3]);
                    if (energyOfPeople.containsKey(attacker) && healthOfPeople.containsKey(defender)) {
                        healthOfPeople.put(defender, healthOfPeople.get(defender) - damage);
                        if (healthOfPeople.get(defender) <= 0) {
                            healthOfPeople.remove(defender);
                            energyOfPeople.remove(defender);
                            System.out.printf("%s was disqualified!%n", defender);
                        }
                        energyOfPeople.put(attacker, energyOfPeople.get(attacker) - 1);
                        if (energyOfPeople.get(attacker) == 0) {
                            energyOfPeople.remove(attacker);
                            healthOfPeople.remove(attacker);
                            System.out.printf("%s was disqualified!%n", attacker);
                        }
                    }
                    break;
                case "Delete":
                    String username = input[1];
                    if (username.equals("All")) {
                        healthOfPeople.clear();
                        energyOfPeople.clear();
                    } else {
                        healthOfPeople.remove(username);
                        energyOfPeople.remove(username);
                    }
                    break;
            }
            input = scanner.nextLine().split(":");
        }
        System.out.printf("People count: %d%n", healthOfPeople.size());
        healthOfPeople.entrySet()
                .stream()
                .sorted((u1, u2) -> u2.getValue().compareTo(u1.getValue()))
                .forEach(user -> System.out.printf("%s - %d - %d%n", user.getKey(), user.getValue(), energyOfPeople.get(user.getKey())));
    }
}