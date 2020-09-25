import java.util.Scanner;
import java.util.regex.Pattern;

public class StringManipulator1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        while (!"End".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "Translate":
                    String toBeReplaced = input[1];
                    String replacement = input[2];
                    text = text.replace(toBeReplaced, replacement);
                    System.out.println(text);
                    break;
                case "Includes":
                    String toBeChecked = input[1];
                    if (text.contains(toBeChecked)) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Start":
                    toBeChecked = input[1];
                    if (text.indexOf(toBeChecked) == 0) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Lowercase":
                    text = text.toLowerCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    char character = input[1].charAt(0);
                    int lastIndex = text.lastIndexOf(character);
                    System.out.println(lastIndex);
                    break;
                case "Remove":
                    int startIndex = Integer.parseInt(input[1]);
                    int count = Integer.parseInt(input[2]);
                    StringBuilder replace = new StringBuilder();
                    for (int i = startIndex; i < startIndex + count; i++) {
                        replace.append(text.charAt(i));
                    }
                    text = text.replace(replace, "");
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine().split(" ");
        }
    }
}