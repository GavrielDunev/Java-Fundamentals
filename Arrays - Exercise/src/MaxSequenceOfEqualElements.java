import java.util.Scanner;

public class MaxSequenceOfEqualElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = scanner.nextLine().split(" ");
        int[] numbers = new int[elements.length];
        int currentCount = 1;
        int biggestCount = 0;
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]= Integer.parseInt(elements[i]);
        }
        for (int i = 0; i < numbers.length - 1; i++) {
            int currentElement = numbers[i];
            int nextElement = numbers[i + 1];
            if (currentElement == nextElement) {
                currentCount++;
            } else {
                currentCount = 1;
            }
            if (currentCount > biggestCount) {
                biggestCount = currentCount;
                number = currentElement;
            }
        }
        for (int i = 0; i < biggestCount; i++) {
            System.out.print(number + " ");
        }
    }
}
