import java.util.Scanner;

public class WorldTour {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stops = scanner.nextLine();
        String[] input = scanner.nextLine().split(":");
        while (!"Travel".equals(input[0])) {
            String command = input[0];
            switch (command) {
                case "Add Stop":
                    int index = Integer.parseInt(input[1]);
                    String toBeAdded = input[2];
                    if (index >= 0 && index < stops.length()) {
                        StringBuilder sb = new StringBuilder(stops);
                        sb.insert(index, toBeAdded);
                        stops = sb.toString();
                    }
                    System.out.println(stops);
                    break;
                case "Remove Stop":
                    int startIndex = Integer.parseInt(input[1]);
                    int endIndex = Integer.parseInt(input[2]);
                    if (startIndex >= 0 && endIndex < stops.length()) {
                        StringBuilder sb = new StringBuilder(stops);
                        sb.delete(startIndex, endIndex + 1);
                        stops = sb.toString();
                    }
                    System.out.println(stops);
                    break;
                case "Switch":
                    String oldString = input[1];
                    String newString = input[2];
                    if (stops.contains(oldString)) {
                        stops = stops.replace(oldString, newString);
                    }
                    System.out.println(stops);
                    break;
            }
            input = scanner.nextLine().split(":");
        }
        System.out.printf("Ready for world tour! Planned stops: %s%n", stops);
    }
}