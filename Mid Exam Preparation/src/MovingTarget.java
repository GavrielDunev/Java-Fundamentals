import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MovingTarget {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String num : nums) {
            int currentNum = Integer.parseInt(num);
            numbers.add(currentNum);
        }
        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("End")) {
            String command = input[0];
            int index = Integer.parseInt(input[1]);
            switch (command) {
                case "Shoot":
                    int power = Integer.parseInt(input[2]);
                    if (index >= 0 && index < numbers.size()) {
                        int currentNum = numbers.get(index);
                        if (currentNum - power <= 0) {
                            numbers.remove(index);
                        } else {
                        numbers.set(index, currentNum - power);
                        }
                    }
                    break;
                case "Add":
                    int value = Integer.parseInt(input[2]);
                    if (index >= 0 && index < numbers.size()) {
                        numbers.add(index, value);
                    }else {
                        System.out.println("Invalid placement!");
                    }
                    break;
                case "Strike":
                    int number = numbers.get(index);
                    int radius = Integer.parseInt(input[2]);
                    int firstRange = index - radius;
                    int secondRange = index + radius;
                    if (firstRange >= 0 && secondRange < numbers.size()) {
                        for (int i = index - 1; i >= firstRange; i--) {
                            int currentNum = numbers.get(i);
                            numbers.remove(Integer.valueOf(currentNum));
                        }
                        index = numbers.indexOf(number);
                        for (int i = index + radius; i >= index; i--) {
                            int currentNum = numbers.get(i);
                            numbers.remove(Integer.valueOf(currentNum));
                        }
                    } else {
                        System.out.println("Strike missed!");
                    }
                    break;
            }
            input = scanner.nextLine().split(" ");
        }
        List<String> stringNums = new ArrayList<>();
        for (Integer number : numbers) {
            stringNums.add(number.toString());
        }
        System.out.println(String.join("|", stringNums));
    }
}
