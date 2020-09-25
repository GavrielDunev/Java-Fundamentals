import java.util.Scanner;

public class SignOfInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        printSign(number);
    }

    public static void printSign(int number) {
        String output = "zero";
        if (number > 0) {
            output = "positive";
        } else if (number < 0) {
            output = "negative";
        }
        System.out.printf("The number %d is %s.", number, output);
    }
}
