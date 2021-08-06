package bakery.entities.bakedFoods.interfaces;

public class Bread extends BaseFood {
    private static final double INITIAL_BREAD_PORTION = 200;

    protected Bread(String name, double portion, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
