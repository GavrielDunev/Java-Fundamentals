import java.util.Scanner;

public class RageExpenses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lostGames = Integer.parseInt(scanner.nextLine());
        double headsetPrice = Double.parseDouble(scanner.nextLine());
        double mousePrice = Double.parseDouble(scanner.nextLine());
        double keyboardPrice = Double.parseDouble(scanner.nextLine());
        double displayPrice = Double.parseDouble(scanner.nextLine());
        int trashedHeadset = 0;
        int trashedMouse = 0;
        int trashedKeyboard = 0;
        for (int i = 1; i <= lostGames; i++) {
            if (i % 2 == 0) {
                trashedHeadset++;
            }
            if (i % 3 == 0) {
                trashedMouse++;
            }
            if (i % 2 == 0 && i % 3 == 0) {
                trashedKeyboard++;
            }
        }
        int trashedDisplay = trashedKeyboard / 2;
        double totalPrice = trashedDisplay * displayPrice + trashedHeadset * headsetPrice + trashedKeyboard * keyboardPrice
                + trashedMouse * mousePrice;
        System.out.printf("Rage expenses: %.2f lv.", totalPrice);

    }
}