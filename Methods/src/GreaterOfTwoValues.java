import java.util.Scanner;

public class GreaterOfTwoValues {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String type = scanner.nextLine();
        if (type.equals("int")) {
            int firstValue = Integer.parseInt(scanner.nextLine());
            int secondValue = Integer.parseInt(scanner.nextLine());
            int result = getMax(firstValue, secondValue);
            System.out.println(result);
        } else if (type.equals("char")) {
            char firstValue = scanner.nextLine().charAt(0);
            char secondValue = scanner.nextLine().charAt(0);
            char result = (char) getMax(firstValue, secondValue);
            System.out.println(result);
        } else {
            String firstValue = scanner.nextLine();
            String secondValue = scanner.nextLine();
            String result = getMax(firstValue, secondValue);
            System.out.println(result);
        }
    }

    private static int getMax(int firstValue, int secondValue) {

        return Math.max(firstValue, secondValue);
    }

    public static int getMax(char firstValue, char secondValue) {
        return Math.max(firstValue, secondValue);
    }

    private static String getMax(String firstValue, String secondValue) {
        String result = "";
        if (firstValue.compareTo(secondValue) > 0) {
            result = firstValue;
        } else {
            result = secondValue;
        }
        return result;
    }
}
