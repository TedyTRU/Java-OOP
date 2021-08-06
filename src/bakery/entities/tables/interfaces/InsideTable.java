package bakery.entities.tables.interfaces;

public class InsideTable extends BaseTable{
    private static final double PRICE_PER_PERSON = 2.50;

    protected InsideTable(int tableNumber, int capacity, double pricePerPerson) {
        super(tableNumber, capacity, PRICE_PER_PERSON);
    }
}
