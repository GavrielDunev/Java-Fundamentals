import java.util.Scanner;

public class SumOfOddNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        int iCounter = 0;
        for (int i = 1; i <= 100; i = i + 2) {
            System.out.println(i);
            sum = sum + i;
            iCounter++;
            if (iCounter == n){
                break;
            }
        }
        System.out.printf("Sum: %d", sum);
    }
}