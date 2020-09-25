import java.util.Random;
import java.util.Scanner;

public class RandomizeWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split(" ");
        Random rnd = new Random();

        for (int i = 0; i < words.length; i++) {
            int random = rnd.nextInt(words.length);
            String temp = words[i];
            words[i] = words[random];
            words[random] = temp;
        }
        for (String word : words) {
            System.out.println(word);
        }
    }
}
