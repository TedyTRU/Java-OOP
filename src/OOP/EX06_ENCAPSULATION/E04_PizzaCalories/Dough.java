package OOP.EX06_ENCAPSULATION.E04_PizzaCalories;

public class Dough {

    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        Validator.validateFlourType(flourType);
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        Validator.validateBakingTechnique(bakingTechnique);
        this.bakingTechnique = bakingTechnique;
    }

    private void setWeight(double weight) {
        Validator.validateDoughWeight(weight);
        this.weight = weight;
    }

    public double calculateCalories() {
        return this.weight * 2 * getModifiersByFlourType(this.flourType) * getModifiersByBakingTechnique(this.bakingTechnique);
    }

    private double getModifiersByFlourType(String flourType) {
        switch (flourType) {
            case "White":
                return 1.5;
            case "Wholegrain":
                return 1.0;
        }

        return 0.0;
    }

    private double getModifiersByBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                return 0.9;
            case "Chewy":
                return 1.1;
            case "Homemade":
                return 1.0;
        }

        return 0.0;
    }


}
