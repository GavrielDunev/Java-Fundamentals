import java.util.Scanner;

public class TopNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        printTopIntegers(n);
    }

    private static void printTopIntegers(int n) {
        for (int i = 1; i <= n; i++) {
            if (isSumOfDigitsDivisibleBy8(i) && holdsAtLeastOneOddDigit(i)) {
                System.out.println(i);
            }
        }
    }

    private static boolean isSumOfDigitsDivisibleBy8(int sum) {
        boolean isDivisible = false;
        int currentSum = 0;
        while (sum > 0) {
            currentSum = currentSum + sum % 10;
            sum = sum / 10;
        }
        if (currentSum % 8 == 0) {
            isDivisible = true;
        }
        return isDivisible;
    }

    private static boolean holdsAtLeastOneOddDigit(int sum) {
        boolean oneOddDigit = false;
        while (sum > 0) {
            int currentNum = sum % 10;
            if (currentNum % 2 != 0) {
                oneOddDigit = true;
                return oneOddDigit;
            }
            sum = sum / 10;
        }
        return oneOddDigit;
    }
}
