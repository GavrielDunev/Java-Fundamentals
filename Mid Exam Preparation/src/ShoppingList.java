import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ShoppingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] items = scanner.nextLine().split("!");
        List<String> listOfItems = new ArrayList<>(Arrays.asList(items));
        String input = scanner.nextLine();
        while (!input.equals("Go Shopping!")) {
            String[] command = input.split(" ");
            switch (command[0]) {
                case "Urgent":
                    String item = command[1];
                    if (!listOfItems.contains(item)) {
                        listOfItems.add(0, item);
                    }
                    break;
                case "Unnecessary":
                    item = command[1];
                    listOfItems.remove(item);
                    break;
                case "Correct":
                    String oldItem = command[1];
                    String newItem = command[2];
                    if (listOfItems.contains(oldItem)) {
                        int oldItemIndex = listOfItems.indexOf(oldItem);
                        listOfItems.set(oldItemIndex, newItem);
                    }
                    break;
                case "Rearrange":
                    item = command[1];
                    if (listOfItems.contains(item)) {
                        listOfItems.remove(item);
                        listOfItems.add(item);
                    }
                    break;
            }
            input = scanner.nextLine();
        }
        System.out.println(String.join(", ", listOfItems));
    }
}
