import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class HearthDelivery {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("@");
        List<Integer> neighbourhoods = new ArrayList<>();

        for (String s : input) {
            int current = Integer.parseInt(s);
            neighbourhoods.add(current);
        }

        String[] command = scanner.nextLine().split(" ");
        int currentIndex = 0;
        int currentNum = 0;
        while (!command[0].equals("Love!")) {
            int length = Integer.parseInt(command[1]);
            currentIndex = currentIndex + length;
            if (currentIndex < neighbourhoods.size()) {
                currentNum = neighbourhoods.get(currentIndex);
                if (currentNum == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
                    command = scanner.nextLine().split(" ");
                    continue;
                }
                neighbourhoods.set(currentIndex, currentNum - 2);
                currentNum = currentNum - 2;
                if (currentNum == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            } else {
                currentIndex = 0;
                currentNum = neighbourhoods.get(currentIndex);
                if (currentNum == 0) {
                    System.out.printf("Place %d already had Valentine's day.%n", currentIndex);
                    command = scanner.nextLine().split(" ");
                    continue;
                }
                neighbourhoods.set(currentIndex, currentNum - 2);
                currentNum = currentNum - 2;
                if (currentNum == 0) {
                    System.out.printf("Place %d has Valentine's day.%n", currentIndex);
                }
            }
            command = scanner.nextLine().split(" ");
        }
        System.out.printf("Cupid's last position was %d.%n", currentIndex);
        int count = 0;
        for (Integer neighbourhood : neighbourhoods) {
            if (neighbourhood != 0) {
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Mission was successful.");
        }else {
            System.out.printf("Cupid has failed %d places.", count);
        }
    }
}
