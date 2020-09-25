import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class StudentAcademy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Double> students = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String studentName = scanner.nextLine();
            double grade = Double.parseDouble(scanner.nextLine());
            if (students.containsKey(studentName)) {
                double average = (grade + students.get(studentName)) / 2;
                students.put(studentName, average);
            } else {
                students.put(studentName, grade);
            }
        }
        students.entrySet()
                .stream()
                .filter(s -> s.getValue() >= 4.50)
                .sorted((s1, s2) -> s2.getValue().compareTo(s1.getValue()))
                .forEach(s -> System.out.printf("%s -> %.2f%n", s.getKey(), s.getValue()));
    }
}
