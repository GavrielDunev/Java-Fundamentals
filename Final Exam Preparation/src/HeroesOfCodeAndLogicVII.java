import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class HeroesOfCodeAndLogicVII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> HP = new LinkedHashMap<>();
        Map<String, Integer> MP = new LinkedHashMap<>();
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String name = input[0];
            int health = Integer.parseInt(input[1]);
            int mana = Integer.parseInt(input[2]);
            HP.put(name, health);
            MP.put(name, mana);
        }
        String[] input = scanner.nextLine().split(" - ");
        while (!"End".equals(input[0])) {
            String command = input[0];
            String heroName = input[1];
            switch (command) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(input[2]);
                    String spellName = input[3];
                    if (MP.get(heroName) >= mpNeeded) {
                        int mpLeft = MP.get(heroName) - mpNeeded;
                        MP.put(heroName, mpLeft);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", heroName, spellName, mpLeft);
                    } else {
                        System.out.printf("%s does not have enough MP to cast %s!%n", heroName, spellName);
                    }
                    break;
                case "TakeDamage":
                    int damage = Integer.parseInt(input[2]);
                    String attacker = input[3];
                    int hpLeft = HP.get(heroName) - damage;
                    if (hpLeft > 0) {
                        HP.put(heroName, hpLeft);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", heroName, damage, attacker, hpLeft);
                    } else {
                        HP.remove(heroName);
                        System.out.printf("%s has been killed by %s!%n", heroName, attacker);
                    }
                    break;
                case "Recharge":
                    int amount = Integer.parseInt(input[2]);
                    int recharge = MP.get(heroName) + amount;
                    boolean isOver = false;
                    if (recharge > 200) {
                        isOver = true;
                        amount = 200 - MP.get(heroName);
                        MP.put(heroName, 200);
                    }
                    if (!isOver) {
                        MP.put(heroName, recharge);
                    }
                    System.out.printf("%s recharged for %d MP!%n", heroName, amount);
                    break;
                case "Heal":
                    amount = Integer.parseInt(input[2]);
                    recharge = HP.get(heroName) + amount;
                    isOver = false;
                    if (recharge > 100) {
                        isOver = true;
                        amount = 100 - HP.get(heroName);
                        HP.put(heroName, 100);
                    }
                    if (!isOver) {
                        HP.put(heroName, recharge);
                    }
                    System.out.printf("%s healed for %d HP!%n", heroName, amount);
                    break;
            }
            input = scanner.nextLine().split(" - ");
        }
        HP.entrySet()
                .stream()
                .sorted((h1, h2) -> {
                    int result = h2.getValue().compareTo(h1.getValue());
                    if (result == 0) {
                        result = h1.getKey().compareTo(h2.getKey());
                    }
                    return result;
                })
                .forEach(h -> {
                    System.out.println(h.getKey());
                    System.out.println(String.format("  HP: %d", h.getValue()));
                    System.out.println(String.format("  MP: %d", MP.get(h.getKey())));
                });
    }
}