import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeePerHour = Integer.parseInt(scanner.nextLine());
        int secondEmployeePerHour = Integer.parseInt(scanner.nextLine());
        int thirdEmployeePerHour = Integer.parseInt(scanner.nextLine());
        int studentsCount = Integer.parseInt(scanner.nextLine());

        int hours = 0;
        while (studentsCount > 0) {
            studentsCount = studentsCount - firstEmployeePerHour - secondEmployeePerHour - thirdEmployeePerHour;
            hours++;
            if (hours % 4 == 0) {
                hours += 1;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
