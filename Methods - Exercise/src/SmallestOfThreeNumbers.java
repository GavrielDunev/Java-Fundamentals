import java.util.Scanner;

public class SmallestOfThreeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        int thirdNumber = Integer.parseInt(scanner.nextLine());
        printSmallestNumber(firstNumber, secondNumber, thirdNumber);
    }

    private static void printSmallestNumber(int a, int b, int c) {
        int smallest = a;
        if (b < a && b < c) {
            smallest = b;
        }
        if (c < b && c < a) {
            smallest = c;
        }
        System.out.println(smallest);
    }
}
