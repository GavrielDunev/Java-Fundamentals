import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MessageTranslator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String regex = "!([A-Z][a-z]{2,})!:\\[([A-z]{8,})\\]";
        Pattern pattern = Pattern.compile(regex);
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.printf("%s:", matcher.group(1));
                String message = matcher.group(2);
                for (int j = 0; j < message.length(); j++) {
                    System.out.print(" " + (int) message.charAt(j));
                }
                System.out.println();
            } else {
                System.out.println("The message is invalid");
            }
        }
    }
}