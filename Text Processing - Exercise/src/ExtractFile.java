import java.util.Scanner;

public class ExtractFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int lastSlash = input.lastIndexOf('\\');
        int lastPoint = input.lastIndexOf('.');
        String fileName = input.substring(lastSlash + 1, lastPoint);
        String fileExtension = input.substring(lastPoint + 1);
        System.out.println(String.format("File name: %s", fileName));
        System.out.println(String.format("File extension: %s", fileExtension));
    }
}