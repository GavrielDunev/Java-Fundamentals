import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationAdvanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(input)
                .map(Integer::parseInt).collect(Collectors.toList());

        String[] command = scanner.nextLine().split(" ");
        while (!"end".equals(command[0])){
            if ("Contains".equals(command[0])){
                int currentNumber = Integer.parseInt(command[1]);
                isContained(numbers, currentNumber);
            } else if ("Print".equals(command[0]) && "even".equals(command[1])) {
                printEvenNumbers(numbers);
            } else if ("Print".equals(command[0]) && "odd".equals(command[1])) {
                printOddNumbers(numbers);
            } else if ("Get".equals(command[0])) {
                getSum(numbers);
            } else if ("Filter".equals(command[0])){
            String condition = command[1];
            int number = Integer.parseInt(command[2]);
            filter(numbers, condition, number);
            }
            command = scanner.nextLine().split(" ");
        }
    }

    private static void isContained(List<Integer> numbers, int num) {
        if (numbers.contains(num)){
            System.out.println("Yes");
        } else {
            System.out.println("No such number");
        }
    }

    private static void printEvenNumbers(List<Integer> numbers) {
        List<Integer> evenNums = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
            evenNums.add(number);
            }
        }
        System.out.println(evenNums.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void printOddNumbers(List<Integer> numbers) {
        List<Integer> oddNums = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 != 0) {
                oddNums.add(number);
            }
        }
        System.out.println(oddNums.toString().replaceAll("[\\[\\],]", ""));
    }

    private static void getSum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum = sum + number;
        }
        System.out.println(sum);
    }

    private static void filter(List<Integer> numbers, String condition, int number) {
        List<Integer> filteredNumbers = new ArrayList<>();
        for (Integer integer : numbers) {
            switch (condition){
                case ">":
                    if (integer > number) {
                        filteredNumbers.add(integer);
                    }
                    break;
                case "<":
                    if (integer < number) {
                        filteredNumbers.add(integer);
                    }
                    break;
                case ">=":
                    if (integer >= number) {
                        filteredNumbers.add(integer);
                    }
                    break;
                case "<=":
                    if (integer <= number) {
                        filteredNumbers.add(integer);
                    }
                    break;
            }
        }
        System.out.println(filteredNumbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
