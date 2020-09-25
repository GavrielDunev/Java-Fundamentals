import java.util.Scanner;

public class Grades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double grade = Double.parseDouble(scanner.nextLine());
        printGrade(grade);
    }

    public static void printGrade(double grade) {
        String gradeInWords = "Fail";
        if (grade >= 3.00 && grade <= 3.49) {
            gradeInWords = "Poor";
        } else if (grade >= 3.50 && grade <= 4.49) {
            gradeInWords = "Good";
        } else if (grade >= 4.50 && grade <= 5.49) {
            gradeInWords = "Very good";
        } else if (grade >= 5.50){
            gradeInWords = "Excellent";
        }
        System.out.println(gradeInWords);
    }
}
