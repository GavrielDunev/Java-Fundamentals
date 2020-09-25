import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmojiDetector {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String thresholdRegex = "\\d";
        Pattern pattern = Pattern.compile(thresholdRegex);
        BigDecimal number = new BigDecimal(1);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        while (matcher.find()) {
            BigDecimal curr = new BigDecimal(Integer.parseInt(matcher.group()));
            number = number.multiply(curr);
        }
        System.out.printf("Cool threshold: %.0f%n", number);

        String emojiRegex = "([:]{2}|[*]{2})(?<emoji>[A-Z][a-z]{2,})\\1";
        Pattern emojiPattern = Pattern.compile(emojiRegex);
        int count  = 0;
        Matcher matcher1 = emojiPattern.matcher(input);
        List<String> coolEmojis = new ArrayList<>();
        while (matcher1.find()) {
            count++;
            String currentMatch = matcher1.group("emoji");
            int sum = 0;
            for (int i = 0; i < currentMatch.length(); i++) {
                sum += (int)currentMatch.charAt(i);
            }
            BigDecimal result = new BigDecimal(sum);
            if (number.compareTo(result) < 0) {
                coolEmojis.add(matcher1.group());
            }
        }
        System.out.printf("%d emojis found in the text. The cool ones are:%n", count);
        for (String coolEmoji : coolEmojis) {
            System.out.println(coolEmoji);
        }
    }
}