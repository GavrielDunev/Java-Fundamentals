import java.util.Scanner;

public class PrintingTriangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.parseInt(scanner.nextLine());
        printTriangle(number);
    }

    private static void printTriangle(int number) {
        printTopHalf(number);
        printBottomHalf(number);
    }

    private static void printTopHalf(int number) {
        for (int i = 1; i <= number; i++) {
            printLine(1, i);
        }
    }

    private static void printBottomHalf(int number) {
        for (int i = number - 1; i >= 1 ; i--) {
            printLine(1, i);
        }
    }

    private static void printLine(int start, int end) {
        for (int i = start; i <= end; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
