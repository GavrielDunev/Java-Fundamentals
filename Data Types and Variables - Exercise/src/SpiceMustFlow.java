import java.util.Scanner;

public class SpiceMustFlow {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startingYield = Integer.parseInt(scanner.nextLine());
        int daysCount = 0;
        int totalExtractedSpice = 0;
        while (startingYield >= 100) {
        daysCount++;
        int extractedSpice = startingYield - 26;
        totalExtractedSpice = totalExtractedSpice + extractedSpice;
        startingYield = startingYield - 10;
        }
        if (totalExtractedSpice >= 26) {
            totalExtractedSpice = totalExtractedSpice - 26;
        }
        System.out.printf("%d%n%d", daysCount, totalExtractedSpice);
    }
}
