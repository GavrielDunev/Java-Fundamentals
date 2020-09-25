import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();
        int sum = 0;
        for (String s : array) {
            int current = Integer.parseInt(s);
            sum += current;
            numbers.add(current);
        }
        double averageValue = sum * 1.0 / numbers.size();
        List<Integer> greaterNumbers = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) > averageValue) {
                greaterNumbers.add(numbers.get(i));
            }
        }
        boolean isEmpty = false;
        Collections.sort(greaterNumbers);
        Collections.reverse(greaterNumbers);
        if (greaterNumbers.size() > 5) {
            while (greaterNumbers.size() > 5) {
                greaterNumbers.remove(greaterNumbers.size() - 1);
            }
        } else if (greaterNumbers.size() == 0) {
            isEmpty = true;
            System.out.println("No");
        }
        if (!isEmpty) {
            for (Integer greaterNumber : greaterNumbers) {
                System.out.print(greaterNumber + " ");
            }
        }
    }
}