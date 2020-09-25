package Students;

import Students.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Student> students = new ArrayList<>();
        while (!input.equals("end")) {
            String[] studentInfo = input.split(" ");
            String firstName = studentInfo[0];
            String lastName = studentInfo[1];
            int age = Integer.parseInt(studentInfo[2]);
            String homeTown = studentInfo[3];
            boolean isStudentExisting = false;
            for (Student currentStudent : students) {
                if (currentStudent.getFirstName().equals(firstName)
                        && currentStudent.getLastName().equals(lastName)) {
                    currentStudent.setAge(age);
                    currentStudent.setHomeTown(homeTown);
                    isStudentExisting = true;
                }
                break;
            }
            if (!isStudentExisting) {
                Student student = new Student(firstName, lastName, age, homeTown);
                students.add(student);
            }
            input = scanner.nextLine();
        }
        String city = scanner.nextLine();

        for (Student student : students) {
            if (city.equals(student.getHomeTown())) {
                System.out.printf("%s %s is %d years old%n", student.getFirstName(), student.getLastName(),
                        student.getAge());
            }
        }
    }
}
