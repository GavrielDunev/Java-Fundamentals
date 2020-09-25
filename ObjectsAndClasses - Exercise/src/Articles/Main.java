package Articles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");
        String title = input[0];
        String content = input[1];
        String author = input[2];
        Article article = new Article(title, content, author);
        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(": ");
            String operation = command[0];
            String newContent = command[1];
            switch (operation) {
                case "Edit":
                    article.editContent(newContent);
                    break;
                case "ChangeAuthor":
                    article.changeAuthor(newContent);
                    break;
                case "Rename":
                    article.rename(newContent);
                    break;
            }
        }
        System.out.println(article);
    }
}
