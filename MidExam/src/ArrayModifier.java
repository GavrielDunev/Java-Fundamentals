import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ArrayModifier {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nums = scanner.nextLine();
        String[] array = nums.split(" ");
        List<Integer> listOfArrays = new ArrayList<>();

        for (String s : array) {
            int current = Integer.parseInt(s);
            listOfArrays.add(current);
        }

        String[] input = scanner.nextLine().split(" ");
        while (!input[0].equals("end")) {
            String command = input[0];
            switch (command) {
                case "swap":
                    int firstIndex = Integer.parseInt(input[1]);
                    int secondIndex = Integer.parseInt(input[2]);
                    int firstElement = listOfArrays.get(firstIndex);
                    int secondElement = listOfArrays.get(secondIndex);
                    listOfArrays.set(firstIndex, secondElement);
                    listOfArrays.set(secondIndex, firstElement);
                    break;
                case "multiply":
                    firstIndex = Integer.parseInt(input[1]);
                    secondIndex = Integer.parseInt(input[2]);
                    firstElement = listOfArrays.get(firstIndex);
                    secondElement = listOfArrays.get(secondIndex);
                    int multiplication = firstElement * secondElement;
                    listOfArrays.set(firstIndex, multiplication);
                    break;
                case "decrease":
                    for (int i = 0; i < listOfArrays.size(); i++) {
                        int currentElement = listOfArrays.get(i);
                        listOfArrays.set(i, currentElement - 1);
                    }
                    break;
            }
            input = scanner.nextLine().split(" ");
        }
        List<String> elements = new ArrayList<>();
        for (Integer listOfArray : listOfArrays) {
            elements.add(listOfArray.toString());
        }
        System.out.println(String.join(", ", elements));
    }
}
