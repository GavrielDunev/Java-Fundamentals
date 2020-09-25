import java.util.Scanner;

public class NikuldensCharity {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String[] tokens = scanner.nextLine().split(" ");
        while (!"Finish".equals(tokens[0])) {
            String command = tokens[0];
            switch (command) {
                case "Replace":
                    String currChar = tokens[1];
                    String newChar = tokens[2];
                    text = replace(currChar, newChar, text);
                    System.out.println(text);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(tokens[1]);
                    int endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(startIndex, endIndex, text.length())) {
                        text = cut(startIndex, endIndex, text);
                        System.out.println(text);
                    }
                    break;
                case "Make":
                    String operation = tokens[1];
                    text = makeLowerOrUpper(operation, text);
                    System.out.println(text);
                    break;
                case "Check":
                    String toBeChecked = tokens[1];
                    check(toBeChecked, text);
                    break;
                case "Sum":
                    startIndex = Integer.parseInt(tokens[1]);
                    endIndex = Integer.parseInt(tokens[2]);
                    if (isValidIndex(startIndex, endIndex, text.length())) {
                        sum(startIndex, endIndex, text);
                    }
                    break;
            }
            tokens = scanner.nextLine().split(" ");
        }
    }

    private static String makeLowerOrUpper(String operation, String text) {
        if ("Lower".equals(operation)) {
            text = text.toLowerCase();
        } else {
            text = text.toUpperCase();
        }
        return text;
    }

    private static void sum(int startIndex, int endIndex, String text) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += text.charAt(i);
        }
        System.out.println(sum);
    }

    private static void check(String toBeChecked, String text) {
        if (text.contains(toBeChecked)) {
            System.out.printf("Message contains %s%n", toBeChecked);
        } else {
            System.out.printf("Message doesn't contain %s%n", toBeChecked);
        }
    }

    private static String cut(int startIndex, int endIndex, String text) {
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        sb.replace(startIndex, endIndex + 1, "");
        return sb.toString();
    }

    private static boolean isValidIndex(int startIndex, int endIndex, int length) {
        if (startIndex >= 0 && endIndex < length) {
            return true;
        } else {
            System.out.println("Invalid indexes!");
            return false;
        }
    }

    private static String replace(String currChar, String newChar, String text) {
        text = text.replace(currChar, newChar);
        return text;
    }
}