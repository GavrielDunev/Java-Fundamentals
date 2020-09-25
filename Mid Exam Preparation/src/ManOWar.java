import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManOWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pirateShip = scanner.nextLine().split(">");
        String [] warShip = scanner.nextLine().split(">");
        int maxHealth = Integer.parseInt(scanner.nextLine());
        List<Integer> pirateShipSections = new ArrayList<>();
        List<Integer> warShipSections = new ArrayList<>();
        readList(pirateShip, pirateShipSections);
        readList(warShip, warShipSections);
        String[] input = scanner.nextLine().split("\\s");
        while (!input[0].equals("Retire")) {
            String command = input[0];
            switch (command) {
                case "Fire":
                    int index = Integer.parseInt(input[1]);
                    if (index <= warShipSections.size() - 1 && index >= 0) {
                        int currentSector = warShipSections.get(index);
                        int damage = Integer.parseInt(input[2]);
                        int sectorHealth = currentSector - damage;
                        if (sectorHealth <= 0) {
                            System.out.println("You won! The enemy ship has sunken.");
                            return;
                        }
                        warShipSections.set(index, sectorHealth);
                    }
                    break;
                case "Defend":
                    int startIndex = Integer.parseInt(input[1]);
                    int endIndex = Integer.parseInt(input[2]);
                    int damage = Integer.parseInt(input[3]);
                    if (startIndex >= 0 && endIndex <= pirateShipSections.size() - 1) {
                        for (int i = startIndex; i <= endIndex; i++) {
                            int currentSector = pirateShipSections.get(i);
                            int sectorHealth = currentSector - damage;
                            if (sectorHealth <= 0) {
                                System.out.println("You lost! The pirate ship has sunken.");
                                return;
                            }
                            pirateShipSections.set(i, sectorHealth);
                        }
                    }
                    break;
                case "Repair":
                    index = Integer.parseInt(input[1]);
                    int health = Integer.parseInt(input[2]);
                    if (index >= 0 && index <= pirateShipSections.size() - 1) {
                        int currentSector = pirateShipSections.get(index);
                        int repairedSector = currentSector + health;
                        if (repairedSector > maxHealth) {
                            repairedSector = maxHealth;
                        }
                        pirateShipSections.set(index, repairedSector);
                    }
                    break;
                case "Status":
                int count = 0;
                    for (Integer pirateShipSection : pirateShipSections) {
                        double percentage = pirateShipSection * 1.0 / maxHealth * 100;
                        if (percentage < 20) {
                            count++;
                        }
                    }
                    System.out.printf("%d sections need repair.%n", count);
                    break;
            }
            input = scanner.nextLine().split("\\s");
        }
        int sumPirateShipStatus = 0;
        for (Integer pirateShipSection : pirateShipSections) {
            sumPirateShipStatus += pirateShipSection;
        }
        int sumWarShipStatus = 0;
        for (Integer warShipSection : warShipSections) {
            sumWarShipStatus += warShipSection;
        }
        System.out.printf("Pirate ship status: %d%n", sumPirateShipStatus);
        System.out.printf("Warship status: %d%n", sumWarShipStatus);
    }

    private static void readList(String[] ship, List<Integer> shipSections) {
        for (String s : ship) {
            int current = Integer.parseInt(s);
            shipSections.add(current);
        }
    }
}
