import java.util.Scanner;

public class MultiplyBigNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String bigNumber = scanner.nextLine();
        int digit = Integer.parseInt(scanner.nextLine());
        StringBuilder result = new StringBuilder();
        while (bigNumber.charAt(0) == '0') {
            bigNumber = bigNumber.substring(1);
        }
        if (digit == 0) {
            System.out.println(0);
            return;
        }
        int remainder = 0;
        for (int i = bigNumber.length() - 1; i >= 0; i--) {
            int lastNum = Integer.parseInt(String.valueOf(bigNumber.charAt(i)));;
            int sum = lastNum * digit + remainder;
            remainder = 0;
            if (sum > 9) {
                remainder = sum / 10;
                sum = sum % 10;
            }
            result.append(sum);
        }
        if (remainder != 0) {
            result.append(remainder);
        }
        System.out.println(result.reverse());
    }
}