import java.util.Scanner;

public class LettersChangeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        double result = 0.0;
        for (String string : input) {
            char firstLetter = string.charAt(0);
            char lastLetter = string.charAt(string.length() - 1);
            String numberAsString = string.substring(1, string.length() - 1);
            long number = Integer.parseInt(numberAsString);
            if (Character.isUpperCase(firstLetter)) {
                result += number * 1.0 / (firstLetter - 64);
            } else {
                result += number * (firstLetter - 96);
            }
            if (Character.isUpperCase(lastLetter)) {
                result -= (lastLetter - 64);
            } else {
                result += (lastLetter - 96);
            }
        }
        System.out.printf("%.2f", result);
    }
}
