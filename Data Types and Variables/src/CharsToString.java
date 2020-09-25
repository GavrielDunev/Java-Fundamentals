import java.util.Scanner;

public class CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char input1 = scanner.nextLine().charAt(0);
        char input2 = scanner.nextLine().charAt(0);
        char input3 = scanner.nextLine().charAt(0);
        System.out.println("" + input1 + input2 + input3);
    }
}