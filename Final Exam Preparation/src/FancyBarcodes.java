import javax.sound.midi.Patch;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FancyBarcodes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "@[#]+([A-Z][A-Za-z0-9]{4,}[A-Z])@[#]+";
        Pattern pattern = Pattern.compile(regex);
        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String input = scanner.nextLine();
            Matcher matcher = pattern.matcher(input);
            if (matcher.find()) {
                String currentMatch = matcher.group(1);
                String productGroup = "";
                String digitRegex = "\\d+";
                Pattern pattern1 = Pattern.compile(digitRegex);
                Matcher matcher1 = pattern1.matcher(currentMatch);
                while (matcher1.find()) {
                    productGroup = productGroup + matcher1.group();
                }
                if (productGroup.equals("")) {
                    productGroup = "00";
                }
                System.out.printf("Product group: %s%n", productGroup);
            } else {
                System.out.println("Invalid barcode");
            }
        }
    }
}
