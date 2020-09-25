import java.util.Scanner;

public class VowelsCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.toLowerCase();
        printVowels(input);
    }

    private static void printVowels(String string) {
        int countVowels = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == 'i' || string.charAt(i) == 'o'
                    || string.charAt(i) == 'a' || string.charAt(i) == 'e'
                    || string.charAt(i) == 'u' || string.charAt(i) == 'y') {
            countVowels++;
            }
        }
        System.out.println(countVowels);
    }
}
