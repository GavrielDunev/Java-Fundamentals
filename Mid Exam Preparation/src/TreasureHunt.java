import java.util.*;

public class TreasureHunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] output = scanner.nextLine().split("\\|");
        List<String> treasureChest = new ArrayList<>(Arrays.asList(output));

        String command = scanner.nextLine();
        while (!command.equals("Yohoho!")) {
            String[] action = command.split(" ");
            switch (action[0]) {
                case "Loot":
                    for (int i = 1; i < action.length; i++) {
                        if (!treasureChest.contains(action[i])) {
                            treasureChest.add(0, action[i]);
                        }
                    }
                    break;
                case "Drop":
                    int index = Integer.parseInt(action[1]);
                    if ((index <= treasureChest.size()) && (index >= 0)) {
                        String loot = treasureChest.get(index);
                        treasureChest.add(loot);
                        treasureChest.remove(index);
                    }
                    break;
                case "Steal":
                    List<String> stolenItems = new ArrayList<>();
                    int count = Integer.parseInt(action[1]);
                    if (count > treasureChest.size()) {
                        count = treasureChest.size();
                    }
                    for (int i = 0; i < count; i++) {
                        stolenItems.add(treasureChest.get(treasureChest.size() - 1));
                        treasureChest.remove(treasureChest.size() - 1);
                    }
                    Collections.reverse(stolenItems);
                    System.out.println(String.join(", ", stolenItems));
                    break;
            }
            command = scanner.nextLine();
        }
        int itemsLength = 0;
        for (String s : treasureChest) {
            itemsLength = itemsLength + s.length();
        }
        double averageGain = itemsLength * 1.0 / treasureChest.size();
        if (treasureChest.size() == 0) {
            System.out.println("Failed treasure hunt.");
        } else {
            System.out.printf("Average treasure gain: %.2f pirate credits.", averageGain);
        }
    }
}
