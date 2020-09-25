import java.util.Scanner;

public class Orders {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        int quantity = Integer.parseInt(scanner.nextLine());
        if (product.equals("coffee")) {
            coffee(quantity);
        } else if (product.equals("water")) {
            water(quantity);
        } else if (product.equals("coke")) {
            coke(quantity);
        } else {
            snacks(quantity);
        }
    }

    private static void coffee(int quantity) {
        System.out.printf("%.2f", quantity * 1.50);
    }

    private static void water(int quantity) {
        System.out.printf("%.2f", quantity * 1.00);
    }

    private static void coke(int quantity) {
        System.out.printf("%.2f", quantity * 1.40);
    }

    private static void snacks(int quantity) {
        System.out.printf("%.2f", quantity * 2.00);
    }
}
