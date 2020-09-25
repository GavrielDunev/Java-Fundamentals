import java.util.Scanner;

public class ConvertMetersToKilometers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberInMeters = Integer.parseInt(scanner.nextLine());
        double numberInKilometers = numberInMeters / 1000.0;
        System.out.printf("%.2f", numberInKilometers);
    }
}