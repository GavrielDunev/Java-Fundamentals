import java.util.Scanner;

public class TopIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int[] numbers = new int[input.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(input[i]);
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int currentNumber = numbers[i];
            boolean isTop = true;
            for (int j = i + 1; j < numbers.length; j++) {
                if (currentNumber <= numbers[j]) {
                    isTop = false;
                    break;
                }
            }
            if (isTop){
                System.out.print(currentNumber + " ");
            }
        }
        System.out.print(numbers[numbers.length - 1]);
    }
}