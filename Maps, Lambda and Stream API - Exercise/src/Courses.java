import java.util.*;

public class Courses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<String>> courses = new LinkedHashMap<>();
        String input = scanner.nextLine();

        while (!"end".equals(input)) {
            String[] tokens = input.split(" : ");
            String courseName = tokens[0];
            String student = tokens[1];
            courses.putIfAbsent(courseName, new ArrayList<>());
            List<String> studentsList = courses.get(courseName);
            studentsList.add(student);
            input = scanner.nextLine();
        }

        courses.entrySet()
                .stream()
                .sorted((c1, c2) -> c2.getValue().size() - c1.getValue().size())
                .forEach(c -> {
                    System.out.printf("%s: %d%n", c.getKey(), c.getValue().size());
                    c.getValue()
                            .stream()
                            .sorted((c1, c2) -> c1.compareTo(c2))
                            .forEach(e -> System.out.printf("-- %s%n", e));
                });
    }
}