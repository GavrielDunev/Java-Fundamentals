import java.util.*;

public class InboxManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> users = new LinkedHashMap<>();
        String[] input = scanner.nextLine().split("->");

        while (!"Statistics".equals(input[0])) {
            String command = input[0];
            String username = input[1];
            switch (command) {
                case "Add":
                    if (users.containsKey(username)) {
                        System.out.printf("%s is already registered%n", username);
                    } else {
                        users.put(username, new ArrayList<>());
                    }
                    break;
                case "Send":
                    String email = input[2];
                    users.get(username).add(email);
                    break;
                case "Delete":
                    if (users.containsKey(username)) {
                        users.remove(username);
                    } else {
                        System.out.printf("%s not found!%n", username);
                    }
                    break;
            }
            input = scanner.nextLine().split("->");
        }
        System.out.printf("Users count: %d%n", users.size());

        users.entrySet()
                .stream()
                .sorted((e1, e2) -> {
                    int result = Integer.compare(e2.getValue().size(), e1.getValue().size());
                    if (result == 0) {
                        result = e1.getKey().compareTo(e2.getKey());
                    }
                    return result;
                })
                .forEach(u -> {
                    System.out.println(u.getKey());
                    for (String email : u.getValue()) {
                        System.out.printf(" - %s%n", email);
                    }
                });
    }
}