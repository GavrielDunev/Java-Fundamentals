import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RemoveNegativesAndReverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] input = scanner.nextLine().split(" ");
        List<Integer> numbers = new ArrayList<>();

        for (String number : input) {
            numbers.add(Integer.parseInt(number));
        }

        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) < 0) {
                numbers.remove(i);
                i = -1;
            }
        }
        Collections.reverse(numbers);
        if (numbers.size() == 0){
            System.out.println("empty");
            return;
        }
        for (Integer number : numbers) {
            System.out.print(number + " ");
        }
    }
}
