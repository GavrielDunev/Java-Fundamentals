import java.util.Scanner;

public class SecretChat {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder message = new StringBuilder(scanner.nextLine());
        String[] input = scanner.nextLine().split(":\\|:");

        while (!"Reveal".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "InsertSpace":
                    int index = Integer.parseInt(input[1]);
                    message.insert(index, " ");
                    System.out.println(message);
                    break;
                case "Reverse":
                    String substring = input[1];
                    if (message.toString().contains(substring)) {
                        int startIndexOfSb = message.indexOf(substring);
                        int endIndexOfSb = startIndexOfSb + substring.length() - 1;
                        StringBuilder toBeAdded = new StringBuilder();
                        for (int i = endIndexOfSb; i >= startIndexOfSb; i--) {
                            toBeAdded.append(message.charAt(i));
                        }
                        message.replace(startIndexOfSb, endIndexOfSb + 1, "");
                        message.append(toBeAdded);
                        System.out.println(message);
                    } else {
                        System.out.println("error");
                    }
                    break;
                case "ChangeAll":
                    substring = input[1];
                    String replacement = input[2];
                    String messageToString = message.toString();
                    messageToString = messageToString.replace(substring, replacement);
                    message = new StringBuilder(messageToString);
                    System.out.println(message);
                    break;
            }

            input = scanner.nextLine().split(":\\|:");
        }
        System.out.printf("You have a new text message: %s", message);
    }
}
