import java.util.Scanner;

public class PasswordValidator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();
        if (!lengthOfString(password)) {
            System.out.println("Password must be between 6 and 10 characters");
        }

        if (!isLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
        }

        if (!atLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
        }

        if (lengthOfString(password) && isLettersAndDigits(password) && atLeastTwoDigits(password)) {
            System.out.println("Password is valid");
        }
    }

    private static boolean lengthOfString(String password) {
        boolean isEnoughLong = false;
        if (password.length() >= 6 && password.length() <= 10) {
            isEnoughLong = true;
        }
        return isEnoughLong;
    }

    private static boolean isLettersAndDigits(String password) {
        password = password.toLowerCase();
        boolean isDigitsAndLetters = false;
        for (int i = 0; i < password.length(); i++) {
            if (!((int) password.charAt(i) >= 97 && (int) password.charAt(i) <= 122 || (int) password.charAt(i) >= 48 && (int) password.charAt(i) <= 57)) {
                isDigitsAndLetters = false;
                break;
            } else {
                isDigitsAndLetters = true;
            }
        }
        return isDigitsAndLetters;
    }

    private static boolean atLeastTwoDigits(String password) {
        boolean atLeastTwoDigits = false;
        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {
            if ((int) password.charAt(i) >= 48 && (int) password.charAt(i) <= 57) {
                countDigits++;
            }
        }
        if (countDigits >= 2) {
            atLeastTwoDigits = true;
        }
        return atLeastTwoDigits;
    }
}

