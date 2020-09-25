import java.util.Scanner;

public class MultiplyEvensByOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Math.abs(Integer.parseInt(scanner.nextLine()));
        System.out.println(getMultiplication(number));
    }

    private static int getMultiplication(int number) {
        int evenSum = getSumOfEvens(number);
        int oddSum = getSumOfOdds(number);
        return evenSum * oddSum;
    }

    private static int getSumOfEvens(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
        if (lastDigit % 2 == 0){
            sum = sum + lastDigit;
        }
        number = number / 10;
        }
        return sum;
    }

    private static int getSumOfOdds(int number) {
        int sum = 0;
        while (number > 0) {
            int lastDigit = number % 10;
            if (lastDigit % 2 != 0){
                sum = sum + lastDigit;
            }
            number = number / 10;
        }
        return sum;
    }
    }
