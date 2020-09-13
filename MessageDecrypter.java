import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageDecrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "^([$%])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<n1>[0-9]+)\\]\\|\\[(?<n2>[0-9)]+)\\]\\|\\[(?<n3>[(0-9)]+)\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                int firstNum = Integer.parseInt(matcher.group("n1"));
                int secondNum = Integer.parseInt(matcher.group("n2"));
                int thirdNum = Integer.parseInt(matcher.group("n3"));
                String decryptedMessage = String.format("%c%c%c", firstNum, secondNum, thirdNum);
                System.out.printf("%s: %s%n", tag, decryptedMessage);
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}