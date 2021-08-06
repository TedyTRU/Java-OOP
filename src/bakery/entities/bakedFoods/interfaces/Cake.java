package bakery.entities.bakedFoods.interfaces;

public class Cake extends BaseFood {
    private static final double INITIAL_BREAD_PORTION = 245;

    protected Cake(String name, double portion, double price) {
        super(name, INITIAL_BREAD_PORTION, price);
    }
}
