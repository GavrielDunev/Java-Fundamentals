import java.util.Scanner;

public class CharacterMultiplier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        String first = input[0];
        String second = input[1];
        int min = Math.min(first.length(), second.length());
        int max = Math.max(first.length(), second.length());
        int totalSum = 0;
        for (int i = 0; i < max; i++) {
            if (i < min) {
                totalSum += first.charAt(i) * second.charAt(i);
            } else if (first.length() == max) {
                totalSum += first.charAt(i);
            } else {
                totalSum += second.charAt(i);
            }
        }
        System.out.println(totalSum);
    }
}
