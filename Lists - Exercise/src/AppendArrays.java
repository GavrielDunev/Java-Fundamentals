import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AppendArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arrays = scanner.nextLine().split("\\|");
        List<String> values = new ArrayList<>();
        for (int i = arrays.length - 1; i >= 0; i--) {
            String[] temp = arrays[i].split("\\s+");
            for (String s : temp) {
                if (!"".equals(s)) {
                    values.add(s);
                }
            }
        }
        System.out.println(String.join(" ", values));
    }
}
