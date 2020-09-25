import java.util.Scanner;

public class AddAndSubtract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int firstNum = Integer.parseInt(scanner.nextLine());
        int secondNum = Integer.parseInt(scanner.nextLine());
        int thirdNum = Integer.parseInt(scanner.nextLine());
        int sum = sumFirstAndSecond(firstNum, secondNum);
        int result = subtractSumAndThird(sum, thirdNum);
        System.out.println(result);
    }

    private static int sumFirstAndSecond(int firstNum, int secondNum) {
        return firstNum + secondNum;
    }

    private static int subtractSumAndThird(int sumFirstAndSecond, int thirdNum) {
        return sumFirstAndSecond - thirdNum;
    }
}
