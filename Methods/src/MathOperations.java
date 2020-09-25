import java.text.DecimalFormat;
import java.util.Scanner;

public class MathOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double firstNumber = Double.parseDouble(scanner.nextLine());
        char operation = scanner.nextLine().charAt(0);
        double secondNumber = Double.parseDouble(scanner.nextLine());
        double finalResult = getResultOfOperation(firstNumber, operation, secondNumber);
        System.out.println(new DecimalFormat("0.##").format(finalResult));
    }

    private static double getResultOfOperation(double firstNumber, char operation, double secondNumber) {
        double result = 0;
        if (operation == '*') {
            result = firstNumber * secondNumber;
        } else if (operation == '/') {
            result = firstNumber / secondNumber;
        } else if (operation == '+') {
            result = firstNumber + secondNumber;
        } else {
            result = firstNumber - secondNumber;
        }
        return result;
    }
}
