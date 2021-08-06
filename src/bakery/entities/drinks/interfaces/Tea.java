package bakery.entities.drinks.interfaces;

public class Tea extends BaseDrink {
    private static final double TEA_PRICE = 2.50;

    protected Tea(String name, int portion, double price, String brand) {
        super(name, portion, TEA_PRICE, brand);
    }
}
