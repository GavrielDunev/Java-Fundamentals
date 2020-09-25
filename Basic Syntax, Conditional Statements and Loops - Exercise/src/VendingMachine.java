import java.util.Scanner;

public class VendingMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String coinsAsString = scanner.nextLine();
        double sum = 0;
        while (!coinsAsString.equals("Start")) {
            double coinsAsDouble = Double.parseDouble(coinsAsString);
            if (coinsAsDouble == 0.1 || coinsAsDouble == 0.2 || coinsAsDouble == 0.5
                    || coinsAsDouble == 1 || coinsAsDouble == 2) {
                sum += coinsAsDouble;
            } else {
                System.out.printf("Cannot accept %.2f%n", coinsAsDouble);
            }
            coinsAsString = scanner.nextLine();
        }
        String product = scanner.nextLine();
        while (!product.equals("End")) {
            switch (product) {
                case "Nuts":
                    if (sum < 2.0) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        sum = sum - 2.0;
                        System.out.println("Purchased " + product);
                    }
                    break;
                case "Water":
                    if (sum < 0.7) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        sum = sum - 0.7;
                        System.out.println("Purchased " + product);
                    }
                    break;
                case "Crisps":
                    if (sum < 1.5) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        sum = sum - 1.5;
                        System.out.println("Purchased " + product);
                    }
                    break;
                case "Soda":
                    if (sum < 0.8) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        sum = sum - 0.8;
                        System.out.println("Purchased " + product);
                    }
                    break;
                case "Coke":
                    if (sum < 1) {
                        System.out.println("Sorry, not enough money");
                    } else {
                        sum = sum - 1;
                        System.out.println("Purchased " + product);
                    }
                    break;
                default:
                    System.out.println("Invalid product");
                    break;
            }
                product = scanner.nextLine();
            }
        System.out.printf("Change: %.2f", sum);
        }
    }