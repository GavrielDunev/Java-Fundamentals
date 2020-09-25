import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SumAdjacentEqualNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Double> numbers = Arrays.stream(input.split(" "))
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        for (int i = 0; i < numbers.size() - 1; i++) {
            double currentNumber = numbers.get(i);
            double nextNumber = numbers.get(i + 1);
            if (currentNumber == nextNumber){
                numbers.remove(i + 1);
                numbers.set(i, currentNumber + nextNumber);
                i = -1;
            }
        }
        printElementWithDelimiter(numbers, " ");
    }

    private static void printElementWithDelimiter(List<Double> numbers, String delimiter) {
        for (Double number : numbers) {
            System.out.print(new DecimalFormat("0.#").format(number) + delimiter);
        }

    }
}
