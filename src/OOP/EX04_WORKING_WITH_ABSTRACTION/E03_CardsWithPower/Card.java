package OOP.EX04_WORKING_WITH_ABSTRACTION.E03_CardsWithPower;

public class Card {
    private CardRank rank;
    private CardSuit suit;
    private int power;

    public Card(CardRank rank, CardSuit suit) {
        this.rank = rank;
        this.suit = suit;
        calculatePower();
    }

    private void calculatePower() {
        this.power = this.rank.getValue() + this.suit.getValue();
        //CardRank.valueOf(this.rank.name()) + CardSuit.valueOf(this.suit.name());
    }

    @Override
    public String toString() {
        return String.format("Card name: %s of %s; Card power: %d", this.rank, this.suit, this.power);
    }
}
