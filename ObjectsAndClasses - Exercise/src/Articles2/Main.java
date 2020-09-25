package Articles2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Article> listArticles = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(", ");
            String title = input[0];
            String content = input[1];
            String author = input[2];
            Article article = new Article(title, content, author);
            listArticles.add(article);
        }
        String input = scanner.nextLine();
        sort(input, listArticles);
    }

    private static void sort(String input, List<Article> listArticles) {
        switch (input) {
            case "title":
                listArticles.stream()
                        .sorted((t1, t2) -> t1.getTitle().compareTo(t2.getTitle()))
                        .forEach(t -> System.out.println(t.toString()));
                break;
            case "content":
                listArticles.stream()
                        .sorted((c1, c2) -> c1.getContent().compareTo(c2.getContent()))
                        .forEach(c -> System.out.println(c.toString()));
                break;
            case "author":
                listArticles.stream()
                        .sorted((a1, a2) -> a1.getAuthor().compareTo(a2.getAuthor()))
                        .forEach(a -> System.out.println(a.toString()));
                break;
        }
    }
}
