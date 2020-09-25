import java.util.Scanner;

public class CalculateRectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double width = Integer.parseInt(scanner.nextLine());
        double length = Integer.parseInt(scanner.nextLine());
        double area = getRectangleArea(width, length);
        System.out.printf("%.0f", area);
    }

    private static double getRectangleArea(double width, double length) {
        return width * length;
    }
}
