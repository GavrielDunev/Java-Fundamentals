import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();
        for (String s : input) {
            numbers.add(Integer.parseInt(s));
        }
        String[] operation = scanner.nextLine().split("\\s+");
        while (!"End".equals(operation[0])) {
            String command = operation[0];
            switch (command) {
                case "Add":
                    int number = Integer.parseInt(operation[1]);
                    numbers.add(number);
                    break;
                case "Insert":
                    number = Integer.parseInt(operation[1]);
                    int index = Integer.parseInt(operation[2]);
                    if (isValid(numbers, index)) {
                        numbers.add(index, number);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(operation[1]);
                    if (isValid(numbers, index)) {
                        numbers.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    int count = Integer.parseInt(operation[2]);
                    if ("left".equals(operation[1])) {
                        for (int i = 0; i < count; i++) {
                            int firstNum = numbers.get(0);
                            numbers.add(firstNum);
                            numbers.remove(Integer.valueOf(firstNum));
                        }
                    } else if ("right".equals(operation[1])) {
                        for (int i = 0; i < count; i++) {
                            int lastNum = numbers.get(numbers.size() - 1);
                            numbers.add(0, lastNum);
                            numbers.remove(numbers.size() - 1);
                        }
                    }
                    break;
            }
            operation = scanner.nextLine().split("\\s+");
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }

    private static boolean isValid(List<Integer> numbers, int index) {
        return index >= 0 && index < numbers.size();
    }
}
