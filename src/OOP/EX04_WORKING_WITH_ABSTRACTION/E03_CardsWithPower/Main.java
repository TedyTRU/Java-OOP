package OOP.EX04_WORKING_WITH_ABSTRACTION.E03_CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String cardRank = sc.nextLine();
        String cardSuit = sc.nextLine();

        Card card = new Card(CardRank.valueOf(cardRank), CardSuit.valueOf(cardSuit));

        System.out.println(card.toString());

    }
}
