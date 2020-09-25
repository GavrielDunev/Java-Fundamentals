import java.util.Scanner;

public class StrongNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numberAsString = scanner.nextLine();
        boolean isStrong = false;
        int totalSum = 0;
        for (int i = 0; i < numberAsString.length(); i++) {
            int digit = Integer.parseInt("" + numberAsString.charAt(i));
            int sum = 1;
            for (int j = digit; j >= 1; j--) {
                sum = sum * j;
            }
            totalSum += sum;
        }
        if (totalSum == Integer.parseInt(numberAsString)){
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}