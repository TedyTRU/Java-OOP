package OOP.EX24_DESIGN_PATTERNS.E01_Factory_Pattern;

public class Main {
    public static void main(String[] args) {

        Pizzeria pizzeria = new Pizzeria(new PizzaFactory());
        pizzeria.orderPizza(PizzaType.CHEESE, 30);
        pizzeria.orderPizza(PizzaType.MEAT, 50);


    }
}
