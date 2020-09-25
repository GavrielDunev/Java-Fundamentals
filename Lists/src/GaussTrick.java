import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GaussTrick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        for (String num : input) {
            int currentNum = Integer.parseInt(num);
            numbers.add(currentNum);
        }
        int length = numbers.size() / 2;
        for (int i = 0; i < length; i++) {
            int firstNum = numbers.get(i);
            int secondNum = numbers.get(numbers.size() - 1);
            numbers.set(i, firstNum + secondNum);
            numbers.remove(numbers.size() - 1);
        }
        printList(numbers);
    }

    private static void printList(List<Integer> numbers) {
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
