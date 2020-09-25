import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Inventory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split(", ");
        List<String> collection = new ArrayList<>(Arrays.asList(items));
        String[] input = scanner.nextLine().split(" - ");
        while (!input[0].equals("Craft!")) {
            String command = input[0];
            switch (command) {
                case "Collect":
                    String item = input[1];
                    if (!collection.contains(item)) {
                        collection.add(item);
                    }
                    break;
                case "Drop":
                    item = input[1];
                    collection.remove(item);
                    break;
                case "Combine Items":
                    String[] currentItems = input[1].split(":");
                    String oldItem = currentItems[0];
                    String newItem = currentItems[1];
                    if (collection.contains(oldItem)) {
                        int oldItemIndex = collection.indexOf(oldItem);
                        collection.add(oldItemIndex + 1, newItem);
                    }
                    break;
                case "Renew":
                    item = input[1];
                    if (collection.contains(item)) {
                        collection.remove(item);
                        collection.add(item);
                    }
                    break;
            }
            input = scanner.nextLine().split(" - ");
        }
        System.out.println(String.join(", ", collection));
    }
}
