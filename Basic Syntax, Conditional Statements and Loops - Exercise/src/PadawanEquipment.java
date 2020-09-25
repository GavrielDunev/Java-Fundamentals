import java.util.Scanner;

public class PadawanEquipment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double money = Double.parseDouble(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());
        double priceOfALightsaber = Double.parseDouble(scanner.nextLine());
        double priceOfARobe = Double.parseDouble(scanner.nextLine());
        double priceOfABelt = Double.parseDouble(scanner.nextLine());
        double totalPriceOfLightsabers = priceOfALightsaber * Math.ceil(students + 0.1 * students);
        int freeBelts = students / 6;
        double costs = priceOfABelt * (students - freeBelts) + priceOfARobe * students + totalPriceOfLightsabers;
        if (costs <= money) {
            System.out.printf("The money is enough - it would cost %.2flv.", costs);
        } else {
            double neededMoney = costs - money;
            System.out.printf("Ivan Cho will need %.2flv more.", neededMoney);
        }
    }
}