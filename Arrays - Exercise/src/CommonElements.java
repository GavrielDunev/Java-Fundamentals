import java.util.Scanner;

public class CommonElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstArray = scanner.nextLine().split(" ");
        String[] secondArrays = scanner.nextLine().split(" ");

        for (String elementOne : secondArrays) {
            for (String elementTwo : firstArray) {
                if (elementOne.equals(elementTwo)) {
                    System.out.print(elementOne + " ");
                    break;
                }
            }
        }
    }
}