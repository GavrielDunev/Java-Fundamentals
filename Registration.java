import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "U\\$([A-Z][a-z]{2,})U\\$P@\\$([A-z]{5,}\\d+)P@\\$";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                System.out.println("Registration was successful");
                String username = matcher.group(1);
                String password = matcher.group(2);
                System.out.printf("Username: %s, Password: %s%n", username, password);
                count++;
            } else {
                System.out.println("Invalid username or password");
            }
        }
        System.out.printf("Successful registrations: %d", count);
    }
}