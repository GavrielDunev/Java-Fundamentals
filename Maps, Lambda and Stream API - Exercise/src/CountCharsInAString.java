import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class CountCharsInAString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Character, Integer> countOfChars = new LinkedHashMap<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar != ' ') {
                if (countOfChars.containsKey(currentChar)) {
                    int count = countOfChars.get(currentChar);
                    countOfChars.put(currentChar, count + 1);
                }else {
                 countOfChars.put(currentChar, 1);
                }
            }
        }
        countOfChars
                .forEach((k, v) -> System.out.println(String.format("%c -> %d", k, v)));
    }
}