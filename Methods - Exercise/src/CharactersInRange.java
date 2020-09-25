import java.util.Scanner;

public class CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);
        if ((int)first < (int)second){
            printCharactersInRange(first, second);
        } else {
            printCharactersInRange(second, first);
        }
    }

    private static void printCharactersInRange(char start, char end) {
        for (int i = start + 1; i < end; i++) {
            System.out.print((char)i + " ");
        }
    }
}
