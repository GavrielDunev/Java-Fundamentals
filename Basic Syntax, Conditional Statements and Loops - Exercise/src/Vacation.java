import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPeople = Integer.parseInt(scanner.nextLine());
        String typeOfGroup = scanner.nextLine();
        String day = scanner.nextLine();
        double price = 0;
        switch (day) {
            case "Friday":
                if (typeOfGroup.equals("Students")) {
                    price = numberOfPeople * 8.45;
                } else if (typeOfGroup.equals("Business")) {
                    if (numberOfPeople >= 100) {
                        numberOfPeople -= 10;
                    }
                    price = numberOfPeople * 10.90;
                } else if (typeOfGroup.equals("Regular")) {
                    price = numberOfPeople * 15;
                }
                break;
            case "Saturday":
                if (typeOfGroup.equals("Students")) {
                    price = numberOfPeople * 9.80;
                } else if (typeOfGroup.equals("Business")) {
                    if (numberOfPeople >= 100) {
                        numberOfPeople -= 10;
                    }
                    price = numberOfPeople * 15.60;
                } else if (typeOfGroup.equals("Regular")) {
                    price = numberOfPeople * 20;
                }
                break;
            case "Sunday":
                if (typeOfGroup.equals("Students")) {
                    price = numberOfPeople * 10.46;
                } else if (typeOfGroup.equals("Business")) {
                    if (numberOfPeople >= 100) {
                        numberOfPeople -= 10;
                    }
                    price = numberOfPeople * 16;
                } else if (typeOfGroup.equals("Regular")) {
                    price = numberOfPeople * 22.50;
                }
                break;
        }
        if (numberOfPeople >= 30 && typeOfGroup.equals("Students")) {
            price = price - 0.15 * price;
        } else if (numberOfPeople >= 10 && typeOfGroup.equals("Regular") && numberOfPeople <= 20) {
            price = price - 0.05 * price;
        }
        System.out.printf("Total price: %.2f", price);
    }
}