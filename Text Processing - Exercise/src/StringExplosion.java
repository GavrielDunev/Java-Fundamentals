import java.util.Scanner;

public class StringExplosion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        StringBuilder string = new StringBuilder();
        int strength = 0;
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == '>') {
                strength += Integer.parseInt(String.valueOf(input.charAt(i + 1)));
                string.append('>');
            } else if (strength == 0) {
                string.append(currentChar);
            } else {
                strength--;
            }
        }
        System.out.println(string);
    }
}
