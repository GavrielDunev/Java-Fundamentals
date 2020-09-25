import java.util.Scanner;

public class FactorialDivision {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long firstNum = Integer.parseInt(scanner.nextLine());
        long secondNum = Integer.parseInt(scanner.nextLine());
        printDivisionOfFactorial(firstNum, secondNum);
    }

    private static void printDivisionOfFactorial(long a, long b) {
        printDivisionOfFactorials(factorialOfFirstNum(a), factorialOfSecondNum(b));
    }

    private static long factorialOfFirstNum(long firstNum) {
        long result = 1;
        for (long i = firstNum; i > 1; i--) {
            result = result * i;
        }
        return result;
    }

    private static long factorialOfSecondNum(long secondNum) {
        long result = 1;
        for (long i = secondNum; i > 1; i--) {
            result = result * i;
        }
        return result;
    }

    private static void printDivisionOfFactorials(double factorialOfFirstNum, double factorialOfSecondNum) {
        System.out.printf("%.2f", factorialOfFirstNum / factorialOfSecondNum);
    }
}
