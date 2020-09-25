import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> wagons = new ArrayList<>();

        for (String s : input) {
            int wagon = Integer.parseInt(s);
            wagons.add(wagon);
        }
        int capacity = Integer.parseInt(scanner.nextLine());
        String[] command = scanner.nextLine().split(" ");
        while (!"end".equals(command[0])) {
            if ("Add".equals(command[0])) {
                int number = Integer.parseInt(command[1]);
                wagons.add(number);
            } else {
                int number = Integer.parseInt(command[0]);
                for (int i = 0; i < wagons.size(); i++) {
                    if (number + wagons.get(i) <= capacity) {
                        wagons.set(i, number + wagons.get(i));
                        break;
                    }
                }
            }

            command = scanner.nextLine().split(" ");
        }

        for (Integer wagon : wagons) {
            System.out.print(wagon + " ");
        }
    }
}
