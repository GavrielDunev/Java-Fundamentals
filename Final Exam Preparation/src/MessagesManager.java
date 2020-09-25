import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MessagesManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> sent = new LinkedHashMap<>();
        Map<String, Integer> received = new TreeMap<>();
        int capacity = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("=");

        while (!"Statistics".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "Add":
                    String username = input[1];
                    int sentMessages = Integer.parseInt(input[2]);
                    int receivedMessages = Integer.parseInt(input[3]);
                    if (!sent.containsKey(username)) {
                        sent.put(username, sentMessages);
                        received.put(username, receivedMessages);
                    }
                    break;
                case "Message":
                    String sender = input[1];
                    String receiver = input[2];
                    if (sent.containsKey(sender) && received.containsKey(receiver)) {
                        sent.put(sender, sent.get(sender) + 1);
                        if (sent.get(sender) + received.get(sender) == capacity) {
                            sent.remove(sender);
                            received.remove(sender);
                            System.out.printf("%s reached the capacity!%n", sender);
                        }
                        received.put(receiver, received.get(receiver) + 1);
                        if (received.get(receiver) + sent.get(receiver) == capacity) {
                            received.remove(receiver);
                            sent.remove(receiver);
                            System.out.printf("%s reached the capacity!%n", receiver);
                        }
                    }
                    break;
                case "Empty":
                    username = input[1];
                    if (username.equals("All")) {
                        sent.clear();
                        received.clear();
                    } else {
                        if (sent.containsKey(username)) {
                            sent.remove(username);
                            received.remove(username);
                        }
                    }
                    break;
            }
            input = scanner.nextLine().split("=");
        }
        System.out.printf("Users count: %d%n", sent.size());
        received.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .forEach(user -> System.out.printf("%s - %d%n", user.getKey(), user.getValue() + sent.get(user.getKey())));
    }
}
