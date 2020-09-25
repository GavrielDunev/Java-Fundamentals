import java.util.Scanner;

public class DigitsLettersAndOthers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder digits = new StringBuilder();
        StringBuilder letters = new StringBuilder();
        StringBuilder others = new StringBuilder();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (Character.isDigit(currentChar)) {
                digits.append(currentChar);
            } else if (Character.isAlphabetic(currentChar)) {
                letters.append(currentChar);
            } else {
                others.append(currentChar);
            }
        }
        System.out.println(digits);
        System.out.println(letters);
        System.out.println(others);
    }
}