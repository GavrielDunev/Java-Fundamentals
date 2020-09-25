import java.util.Scanner;

public class ReverseStrings {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!"end".equals(input)) {
            String reversedWord = "";
            for (int i = input.length() - 1; i >= 0; i--) {
                reversedWord += input.charAt(i);
            }
            System.out.printf("%s = %s%n", input, reversedWord);
            input = scanner.nextLine();
        }
    }
}
