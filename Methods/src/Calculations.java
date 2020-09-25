import java.util.Scanner;

public class Calculations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        int firstNumber = Integer.parseInt(scanner.nextLine());
        int secondNumber = Integer.parseInt(scanner.nextLine());
        if (command.equals("add")) {
            printAddition(firstNumber, secondNumber);
        } else if (command.equals("multiply")) {
            printMultiplication(firstNumber, secondNumber);
        } else if (command.equals("subtract")) {
            printSubraction(firstNumber,secondNumber);
        } else {
            printDivision(firstNumber,secondNumber);
        }
    }

    private static void printAddition(int firstNumber, int secondNumber) {
        System.out.println(firstNumber + secondNumber);
    }

    private static void printMultiplication(int firstNumber, int secondNumber) {
        System.out.println(firstNumber * secondNumber);
    }

    private static void printSubraction(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }

    private static void printDivision(int firstNumber, int secondNumber) {
        System.out.println(firstNumber / secondNumber);
    }
}
