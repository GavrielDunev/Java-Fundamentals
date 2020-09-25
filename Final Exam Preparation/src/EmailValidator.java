import java.util.Scanner;

public class EmailValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email = scanner.nextLine();
        String[] input = scanner.nextLine().split(" ");

        while (!"Complete".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "Make":
                    String wordSize = input[1];
                    if (wordSize.equals("Upper")) {
                        email = email.toUpperCase();
                    } else {
                        email = email.toLowerCase();
                    }
                    System.out.println(email);
                    break;
                case "GetDomain":
                    int count = Integer.parseInt(input[1]);
                    int startIndex = email.length() - count;
                    System.out.println(email.substring(startIndex));
                    break;
                case "GetUsername":
                    if (email.contains("@")) {
                        int indexOfSymbol = email.indexOf('@');
                        System.out.println(email.substring(0, indexOfSymbol));
                    } else {
                        System.out.printf("The email %s doesn't contain the @ symbol.%n", email);
                    }
                    break;
                case "Replace":
                    String character = input[1];
                    email = email.replace(character, "-");
                    System.out.println(email);
                    break;
                case "Encrypt":
                    for (int i = 0; i < email.length(); i++) {
                        System.out.print((int) email.charAt(i) + " ");
                    }
                    System.out.println();
                    break;
            }

            input = scanner.nextLine().split(" ");
        }
    }
}