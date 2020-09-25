package Students;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Student> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            String firstName = input[0];
            String lastName = input[1];
            double grade = Double.parseDouble(input[2]);
            Student student = new Student(firstName, lastName, grade);
            students.add(student);
        }

        students.stream()
                .sorted((g1, g2) -> Double.compare(g2.getGrade(), g1.getGrade()))
                .forEach(g -> System.out.println(g.toString()));
    }
}
