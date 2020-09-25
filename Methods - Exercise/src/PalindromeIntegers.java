import java.util.Scanner;

public class PalindromeIntegers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        while (!number.equals("END")) {
            int currentNum = Integer.parseInt(number);
            System.out.println(isPalindrome(currentNum));
            number = scanner.nextLine();
        }
    }

    private static boolean isPalindrome(int currentNum) {
        boolean isPalindrome = false;
        if (reversedNum(currentNum) == currentNum) {
            isPalindrome = true;
        }
        return isPalindrome;
    }

    private static int reversedNum(int currentNum) {
        int reversed = 0;
        while (currentNum > 0) {
            int currentDigit = currentNum % 10;
            reversed = reversed * 10 + currentDigit;
            currentNum = currentNum / 10;
        }
        return reversed;
    }
}
