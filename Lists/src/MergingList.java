import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MergingList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split(" ");
        String[] second = scanner.nextLine().split(" ");
        List<Integer> firstList = readList(first);
        List<Integer> secondList = readList(second);
        resultList(firstList, secondList);
    }

    private static List<Integer> readList(String[] first) {
        List<Integer> numbers = new ArrayList<>();
        for (String s : first) {
            numbers.add(Integer.parseInt(s));
        }
        return numbers;
    }

    private static void resultList(List<Integer> firstList, List<Integer> secondList) {
        List<Integer> result = new ArrayList<>();
        int minLength = Math.min(firstList.size(), secondList.size());
        int maxLength = Math.max(firstList.size(), secondList.size());
        for (int i = 0; i < minLength; i++) {
            result.add(firstList.get(i));
            result.add(secondList.get(i));
        }
        for (int i = minLength; i < maxLength; i++) {
            if (firstList.size() > secondList.size()) {
                result.add(firstList.get(i));
            } else {
                result.add(secondList.get(i));
            }
        }
        for (Integer number : result) {
            System.out.print(number + " ");
        }
    }
}
