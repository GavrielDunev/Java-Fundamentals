import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DestinationManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([=\\/])(?<name>[A-Z][A-z]{2,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String input = scanner.nextLine();
        Matcher matcher = pattern.matcher(input);
        int travelPoints = 0;
        List<String> destinations = new LinkedList<>();
        while (matcher.find()) {
            destinations.add(matcher.group("name"));
            travelPoints += matcher.group("name").length();
        }
        System.out.print("Destinations: ");
        System.out.println(destinations.toString().replaceAll("[\\[\\]]", ""));
        System.out.printf("Travel Points: %d", travelPoints);
    }
}
