import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MirrorWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regex = "([@#])(?<first>[A-Za-z]{3,})\\1\\1(?<second>[A-Za-z]{3,})\\1";
        Pattern pattern = Pattern.compile(regex);
        String text = scanner.nextLine();
        Matcher matcher = pattern.matcher(text);
        int count = 0;
        List<String> mirrorWords = new ArrayList<>();
        while (matcher.find()) {
            count++;
            String firstWord = matcher.group("first");
            String secondWord = matcher.group("second");
            StringBuilder secondBackwards = new StringBuilder();
            for (int i = secondWord.length() - 1; i >= 0; i--) {
                secondBackwards.append(secondWord.charAt(i));
            }
            if (firstWord.equals(secondBackwards.toString())) {
                mirrorWords.add(String.format("%s <=> %s", firstWord, secondWord));
            }
        }
        if (count == 0) {
            System.out.println("No word pairs found!");
        } else {
            System.out.printf("%d word pairs found!%n", count);
        }
        if (mirrorWords.size() == 0) {
            System.out.println("No mirror words!");
        } else {
            System.out.printf("The mirror words are:%n");
            System.out.print(mirrorWords.toString().replaceAll("[\\[\\]]", ""));
        }
    }
}
