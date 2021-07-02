package OOP.EX06_ENCAPSULATION.E04_PizzaCalories;

public class Topping {

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    public String getToppingType() {
        return toppingType;
    }

    private void setToppingType(String toppingType) {
        Validator.validateToppingType(toppingType);
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        Validator.validateToppingWeight(weight, this.toppingType);
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 * this.getModifiersByToppingType(this.toppingType);
    }

    private double getModifiersByToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                return 1.2;

            case "Veggies":
                return 0.8;

            case "Cheese":
                return 1.1;

            case "Sauce":
                return 0.9;
        }

        return 0.0;
    }
}


