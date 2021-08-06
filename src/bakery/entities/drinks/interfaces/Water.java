package bakery.entities.drinks.interfaces;

public class Water extends BaseDrink {
    private static final double WATER_PRICE = 1.50;

    protected Water(String name, int portion, double price, String brand) {
        super(name, portion, WATER_PRICE, brand);
    }
}
