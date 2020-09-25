import java.util.Scanner;

public class RepeatString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int repetitions = Integer.parseInt(scanner.nextLine());
        String finalResult = repeatString(input, repetitions);
        System.out.println(finalResult);
    }

    private static String repeatString(String input, int repetitions) {
        String result = "";
        for (int i = 0; i < repetitions; i++) {
            result = result + input;
        }
        return result;
    }
}
