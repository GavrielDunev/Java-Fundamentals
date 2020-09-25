import java.util.Scanner;

public class PokeMon {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pokePower = Integer.parseInt(scanner.nextLine());
        int distance = Integer.parseInt(scanner.nextLine());
        int exhaustionFactor = Integer.parseInt(scanner.nextLine());
        int targetsPoked = 0;
        double halfPower = pokePower - 0.5 * pokePower;
        while (pokePower >= distance) {
            pokePower = pokePower - distance;
            targetsPoked++;
            boolean isHalfPower = pokePower == halfPower;
            if (isHalfPower && exhaustionFactor > 0) {
            pokePower = pokePower / exhaustionFactor;
            }
        }
        System.out.printf("%d%n%d", pokePower, targetsPoked);
    }
}
