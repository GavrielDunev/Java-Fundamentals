import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChangeList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] nums = scanner.nextLine().split("\\s+");
        List<Integer> numbers = new ArrayList<>();

        for (String num : nums) {
                int currentNum = Integer.parseInt(num);
                numbers.add(currentNum);
        }
        String[] command = scanner.nextLine().split("\\s+");
            while (!"end".equals(command[0])) {
                String operation = command[0];
                int element = Integer.parseInt(command[1]);
                switch (operation) {
                    case "Delete":
                        while (numbers.contains(element)) {
                            numbers.remove(Integer.valueOf(element));
                        }
                        break;
                    case "Insert":
                        int index = Integer.parseInt(command[2]);
                        if (index >= 0 && index < numbers.size()) {
                            numbers.add(index, element);
                        }
                        break;
                    default:
                        break;
                }
                command = scanner.nextLine().split("\\s+");
            }

            System.out.print(numbers.toString().replaceAll("[\\[\\],]", ""));
        }
    }