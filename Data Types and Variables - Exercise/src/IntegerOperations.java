import java.util.Scanner;

public class IntegerOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long firstNumber = Integer.parseInt(scanner.nextLine());
        long secondNumber = Integer.parseInt(scanner.nextLine());
        long thirdNumber = Integer.parseInt(scanner.nextLine());
        long fourthNumber = Integer.parseInt(scanner.nextLine());
        long sum = firstNumber + secondNumber;
        long division = sum / thirdNumber;
        long result = division * fourthNumber;
        System.out.println(result);
    }
}
