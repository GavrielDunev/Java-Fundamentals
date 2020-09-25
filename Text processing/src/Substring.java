import java.util.Scanner;

public class Substring {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String keyWord = scanner.nextLine();
        String input = scanner.nextLine();
        while (input.contains(keyWord)) {
            int indexOfKeyWord = input.indexOf(keyWord);
            input = input.substring(0, indexOfKeyWord) + input.substring(indexOfKeyWord + keyWord.length());
        }
        System.out.println(input);
    }
}