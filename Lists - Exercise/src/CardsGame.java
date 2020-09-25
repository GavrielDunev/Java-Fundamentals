import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CardsGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split("\\s+");
        String[] second = scanner.nextLine().split("\\s+");
        List<Integer> firstPlayerCards = readList(first);
        List<Integer> secondPlayerCards = readList(second);
        while (!(firstPlayerCards.size() == 0 || secondPlayerCards.size() == 0)) {
            int cardOfFirstPlayer = firstPlayerCards.get(0);
            int cardOfSecondPlayer = secondPlayerCards.get(0);
            if (cardOfFirstPlayer > cardOfSecondPlayer) {
                firstPlayerCards.add(cardOfFirstPlayer);
                firstPlayerCards.remove(firstPlayerCards.get(0));
                firstPlayerCards.add(cardOfSecondPlayer);
                secondPlayerCards.remove(0);
            } else if (cardOfFirstPlayer < cardOfSecondPlayer) {
                secondPlayerCards.add(cardOfSecondPlayer);
                secondPlayerCards.remove(secondPlayerCards.get(0));
                secondPlayerCards.add(cardOfFirstPlayer);
                firstPlayerCards.remove(0);
            } else {
                firstPlayerCards.remove(0);
                secondPlayerCards.remove(0);
            }
        }
        String winner = "";
        if (firstPlayerCards.size() > secondPlayerCards.size()) {
            winner = "First player wins!";
            printWinner(firstPlayerCards, winner);
        } else {
            winner = "Second player wins!";
            printWinner(secondPlayerCards, winner);
        }
    }

    private static List<Integer> readList(String[] cards) {
        List<Integer> cardsOfPlayer = new ArrayList<>();
        for (String card : cards) {
            int currentCard = Integer.parseInt(card);
            cardsOfPlayer.add(currentCard);
        }
        return cardsOfPlayer;
    }

    private static void printWinner(List<Integer> cards, String winner) {
        int sum = 0;
        for (Integer card : cards) {
            sum = sum + card;
        }
        System.out.printf("%s Sum: %d", winner, sum);
    }
}
