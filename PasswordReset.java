import java.util.Scanner;

public class PasswordReset {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");

        while (!"Done".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "TakeOdd":
                    StringBuilder sb = new StringBuilder();
                    for (int i = 1; i < password.length(); i = i + 2) {
                        sb.append(password.charAt(i));
                    }
                    password = sb.toString();
                    System.out.println(password);
                    break;
                case "Cut":
                    int startIndex = Integer.parseInt(input[1]);
                    int length = Integer.parseInt(input[2]);
                    int endIndex = startIndex + length;
                    StringBuilder toReplace = new StringBuilder(password);
                    toReplace.replace(startIndex, endIndex, "");
                    password = toReplace.toString();
                    System.out.println(password);
                    break;
                case "Substitute":
                    String substring = input[1];
                    String substitute = input[2];
                    if (password.contains(substring)) {
                        password = password.replace(substring, substitute);
                        System.out.println(password);
                    } else {
                        System.out.println("Nothing to replace!");
                    }
                    break;
            }

            input = scanner.nextLine().split(" ");
        }
        System.out.printf("Your password is: %s", password);
    }
}
