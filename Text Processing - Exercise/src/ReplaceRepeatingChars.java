import java.util.Scanner;

public class ReplaceRepeatingChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder sb = new StringBuilder(String.valueOf(input.charAt(0)));
        for (int i = 1; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            char lastCharOfSb = sb.charAt(sb.length() - 1);
            if (currentChar != lastCharOfSb) {
                sb.append(currentChar);
            }
        }
        System.out.println(sb);
    }
}