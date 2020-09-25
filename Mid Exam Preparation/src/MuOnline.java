import java.util.Scanner;

public class MuOnline {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] rooms = scanner.nextLine().split("\\|");
        int health = 100;
        int bitcoins = 0;
        for (int i = 0; i < rooms.length; i++) {
            String[] input = rooms[i].split(" ");
            String command = input[0];
            switch (command) {
                case "potion":
                    int additionalHealth = Integer.parseInt(input[1]);
                    int fullHealth = health + additionalHealth;
                    if (fullHealth > 100) {
                        additionalHealth = additionalHealth - (fullHealth - 100) ;
                        fullHealth = 100;
                    }
                    health = fullHealth;
                    System.out.printf("You healed for %d hp.%n", additionalHealth);
                    System.out.printf("Current health: %d hp.%n", health);
                    break;
                case "chest":
                    int foundBitcoins = Integer.parseInt(input[1]);
                    bitcoins += foundBitcoins;
                    System.out.printf("You found %d bitcoins.%n", foundBitcoins);
                    break;
                default:
                    String monster = input[0];
                    int damage = Integer.parseInt(input[1]);
                    health -= damage;
                    if (health > 0) {
                        System.out.printf("You slayed %s.%n", monster);
                    } else {
                        System.out.printf("You died! Killed by %s.%n", monster);
                        int bestRoom = i + 1;
                        System.out.printf("Best room: %d%n", bestRoom);
                        return;
                    }
                    break;
            }
        }
        System.out.printf("You've made it!%nBitcoins: %d%nHealth: %d", bitcoins, health);
    }
}
