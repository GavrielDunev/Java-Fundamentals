import java.util.Scanner;

public class ArrayRotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(" ");
        int numberOfRotations = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numberOfRotations; i++) {

            String firstDigit = numbers[0];
            for (int j = 0; j < numbers.length - 1; j++) {
                numbers[j] = numbers[j + 1];
            }
            numbers[numbers.length - 1] = firstDigit;
        }
        System.out.println(String.join(" ", numbers));
    }
}
