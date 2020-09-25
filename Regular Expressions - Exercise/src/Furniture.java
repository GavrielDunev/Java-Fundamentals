import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Furniture {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = ">>(?<name>\\w+)<<(?<price>\\d+\\.?\\d*)!(?<quantity>\\d+)";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        List<String> furniture = new ArrayList<>();
        double totalPrice = 0.0;
        while (!"Purchase".equals(input)) {
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
            furniture.add(matcher.group("name"));
            int quantity = Integer.parseInt(matcher.group("quantity"));
            double price = Double.parseDouble(matcher.group("price"));
            totalPrice += quantity * price;
            }
            input = scanner.nextLine();
        }
        System.out.println("Bought furniture:");
        for (String s : furniture) {
            System.out.println(s);
        }
        System.out.printf("Total money spend: %.2f", totalPrice);
    }
}