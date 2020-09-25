import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int wagons = Integer.parseInt(scanner.nextLine());
        int[] people = new int[wagons];
        for (int i = 0; i < people.length; i++) {
            people[i] = Integer.parseInt(scanner.nextLine());
        }
        int sum = 0;
        for (int currentNumber : people) {
            sum = sum + currentNumber;
            System.out.print(currentNumber + " ");
        }
        System.out.println();
        System.out.println(sum);
    }
}