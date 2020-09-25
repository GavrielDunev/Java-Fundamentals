import java.util.Scanner;

public class NationalCourt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstEmployeePerHours = Integer.parseInt(scanner.nextLine());
        int secondEmployeePerHours = Integer.parseInt(scanner.nextLine());
        int thirdEmployeePerHours = Integer.parseInt(scanner.nextLine());
        int totalPeople = Integer.parseInt(scanner.nextLine());
        int hours = 0;
        while (totalPeople > 0) {
                totalPeople = totalPeople - firstEmployeePerHours - secondEmployeePerHours - thirdEmployeePerHours;
                hours++;
                if (hours % 4 == 0) {
                    hours += 1;
                }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
