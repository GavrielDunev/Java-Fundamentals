import java.util.Scanner;

public class CounterStrike {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int initialEnergy = Integer.parseInt(scanner.nextLine());
        String input = scanner.nextLine();
        int count = 0;
        while (!input.equals("End of battle")) {
            int energy = Integer.parseInt(input);
            if (energy <= initialEnergy) {
                initialEnergy = initialEnergy - energy;
                count++;
                if (count != 0 && count % 3 == 0) {
                    initialEnergy = initialEnergy + count;
                }
            } else {
                System.out.printf("Not enough energy! Game ends with %d won battles and %d energy", count, initialEnergy);
                return;
            }
            input = scanner.nextLine();
        }
        System.out.printf("Won battles: %d. Energy left: %d", count, initialEnergy);
    }
}