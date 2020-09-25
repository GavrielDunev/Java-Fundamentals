import java.util.Scanner;
import java.util.regex.Pattern;

public class StringManupulator2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");
        while (!"Done".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "Change":
                    String character = input[1];
                    String replacement = input[2];
                    text = text.replace(character, replacement);
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
                case "End":
                    toBeChecked = input[1];
                    StringBuilder sb = new StringBuilder();
                    for (int i = text.length() - toBeChecked.length(); i < text.length(); i++) {
                        sb.append(text.charAt(i));
                    }
                    if (toBeChecked.equals(sb.toString())) {
                        System.out.println("True");
                    } else {
                        System.out.println("False");
                    }
                    break;
                case "Uppercase":
                    text = text.toUpperCase();
                    System.out.println(text);
                    break;
                case "FindIndex":
                    character = input[1];
                    int firstIndex = text.indexOf(character);
                    System.out.println(firstIndex);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(input[1]);
                    int length = Integer.parseInt(input[2]);
                    text = text.substring(startIndex, startIndex + length);
                    System.out.println(text);
                    break;
            }
            input = scanner.nextLine().split(" ");
        }
    }
}
