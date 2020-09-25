import java.util.*;

public class CompanyUsers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> companies = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!"End".equals(input)) {
            String[] tokens = input.split(" -> ");
            String companyName = tokens[0];
            String id = tokens[1];
            companies.putIfAbsent(companyName, new ArrayList<>());
            List<String> listOfId = companies.get(companyName);
            if (!listOfId.contains(id)) {
                listOfId.add(id);
            }
            input = scanner.nextLine();
        }
        companies.entrySet()
                .stream()
                .sorted((n1, n2) -> n1.getKey().compareTo(n2.getKey()))
                .forEach(e -> {
                    System.out.printf("%s%n", e.getKey());
                    e.getValue().forEach(id -> System.out.printf("-- %s%n", id));
                });
    }
}