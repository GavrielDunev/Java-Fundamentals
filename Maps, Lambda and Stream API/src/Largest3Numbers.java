import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Largest3Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = Arrays.stream(scanner.nextLine().split(" "))
                .map(e -> Integer.parseInt(e))
                .sorted((l, r) -> r.compareTo(l))
                .limit(3)
                .map(n -> n.toString())
                .collect(Collectors.joining(" "));
        System.out.println(result);
    }
}