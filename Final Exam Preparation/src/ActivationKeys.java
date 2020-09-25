import java.util.Scanner;

public class ActivationKeys {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String key = scanner.nextLine();
        String[] input = scanner.nextLine().split(">>>");

        while (!input[0].equals("Generate")) {
            String command = input[0];
            switch (command) {
                case "Contains":
                    String toBeChecked = input[1];
                    if (key.contains(toBeChecked)) {
                        System.out.printf("%s contains %s%n", key, toBeChecked);
                    } else {
                        System.out.println("Substring not found!");
                    }
                    break;
                case "Flip":
                    String sizeOfWord = input[1];
                    int startIndex = Integer.parseInt(input[2]);
                    int endIndex = Integer.parseInt(input[3]);
                    String replacement = key.substring(startIndex, endIndex);
                    if (sizeOfWord.equals("Lower")) {
                        key = key.replace(replacement, replacement.toLowerCase());
                    } else {
                        key = key.replace(replacement, replacement.toUpperCase());
                    }
                    System.out.println(key);
                    break;
                case "Slice":
                    startIndex = Integer.parseInt(input[1]);
                    endIndex = Integer.parseInt(input[2]);
                    replacement = key.substring(startIndex, endIndex);
                    key = key.replace(replacement, "");
                    System.out.println(key);
                    break;
            }

            input = scanner.nextLine().split(">>>");
        }
        System.out.printf("Your activation key is: %s", key);
    }
}