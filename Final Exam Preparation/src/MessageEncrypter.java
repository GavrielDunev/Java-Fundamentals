import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageEncrypter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([*@])(?<tag>[A-Z][a-z]{2,})\\1: \\[(?<n1>[A-z])\\]\\|\\[(?<n2>[A-z])\\]\\|\\[(?<n3>[A-z])\\]\\|$";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String tag = matcher.group("tag");
                String first = matcher.group("n1");
                String second = matcher.group("n2");
                String third = matcher.group("n3");
                System.out.printf("%s: %d %d %d%n", tag, (int)first.charAt(0), (int)second.charAt(0), (int)third.charAt(0));
            } else {
                System.out.println("Valid message not found!");
            }
        }
    }
}