import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShootForTheWin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] nums = input.split(" ");
        int[] numbers = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numbers[i] = Integer.parseInt(nums[i]);
        }

        int shotTargets = 0;
        input = scanner.nextLine();
        while (!input.equals("End")) {
            int index = Integer.parseInt(input);
            if (index >= 0 && index < numbers.length) {
                if (numbers[index] != -1) {
                    int shotNumber = numbers[index];
                    numbers[index] = -1;
                    shotTargets++;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] != -1 && numbers[i] > shotNumber) {
                            numbers[i] = numbers[i] - shotNumber;
                        }else if (numbers[i] != -1 && numbers[i] <= shotNumber) {
                            numbers[i] = numbers[i] + shotNumber;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        System.out.printf("Shot targets: %d ->", shotTargets);
        for (int number : numbers) {
            System.out.print(" " + number);
        }
    }
}
