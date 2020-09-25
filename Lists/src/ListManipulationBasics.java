import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ListManipulationBasics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split(" ");
        List<Integer> numbers = Arrays.stream(nums)
                .map(Integer::parseInt).collect(Collectors.toList());
        String[] command = scanner.nextLine().split(" ");
        while (!"end".equals(command[0])) {
            String operation = command[0];
            int number = Integer.parseInt(command[1]);
            switch (operation) {
                case "Add":
                numbers.add(number);
                    break;
                case "Remove":
                numbers.remove(Integer.valueOf(number));
                    break;
                case "RemoveAt":
                    int index = Integer.parseInt(command[1]);
                numbers.remove(index);
                    break;
                case "Insert":
                    index = Integer.parseInt(command[2]);
                numbers.add(index, number);
                    break;
            }
            command = scanner.nextLine().split(" ");
        }
        System.out.println(numbers.toString().replaceAll("[\\[\\],]", ""));
    }
}
