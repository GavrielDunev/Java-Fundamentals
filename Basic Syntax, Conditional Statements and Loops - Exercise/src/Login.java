import java.util.Scanner;

public class Login {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        String password = "";
        String input = scanner.nextLine();
        for (int i = username.length() - 1; i >= 0; i--) {
            password = password + username.charAt(i);
        }
        for (int i = 0; i < 4; i++) {
            if (input.equals(password)) {
                System.out.printf("User %s logged in.", username);
                break;
            } else {
                if (i == 3) {
                    System.out.printf("User %s blocked!", username);
                    break;
                }
                System.out.println("Incorrect password. Try again.");
                input = scanner.nextLine();
            }
        }
    }
}