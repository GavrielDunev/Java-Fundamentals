import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BombNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        String[] bombInfo = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String num : nums) {
            int currentNum = Integer.parseInt(num);
            numbers.add(currentNum);
        }

        int bombNumber = Integer.parseInt(bombInfo[0]);
        int bombPower = Integer.parseInt(bombInfo[1]);
        while (numbers.contains(bombNumber)) {
            detonateLeftNumbers(numbers, bombNumber, bombPower);
            detonateRightNumber(numbers, bombNumber, bombPower);
        }
        printSumOfNumbers(numbers);
    }

    private static void detonateLeftNumbers(List<Integer> numbers, int bombNumber, int bombPower) {
        int end = numbers.indexOf(bombNumber) - bombPower;
        int start = numbers.indexOf(bombNumber);
        if (end < 0){
            end = 0;
        }
        for (int i = start - 1; i >= end; i--) {
            numbers.remove(i);
        }
    }

    private static void detonateRightNumber(List<Integer> numbers, int bombNumber, int bombPower) {
        int start = numbers.indexOf(bombNumber) + bombPower;
        int end = numbers.indexOf(bombNumber);
        if (start + bombPower > numbers.size()){
            start = numbers.size() - 1;
        }
        for (int i = start; i >= end; i--) {
        numbers.remove(i);
        }
    }

    private static void printSumOfNumbers(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum = sum + number;
        }
        System.out.println(sum);
    }
}
