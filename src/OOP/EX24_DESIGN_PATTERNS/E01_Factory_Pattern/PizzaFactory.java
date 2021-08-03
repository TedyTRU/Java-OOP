package OOP.EX24_DESIGN_PATTERNS.E01_Factory_Pattern;

public class PizzaFactory {

    public Pizza createPizza(PizzaType type, int diameter) {
        Pizza pizza = null;

        switch (type) {
            case ITALIAN -> pizza = new ItalianPizza(diameter);

            case CHEESE -> pizza = new CheesePizza(diameter);

            case MEAT -> pizza = new MeatPizza(diameter);

        }

        return pizza;
    }
}
