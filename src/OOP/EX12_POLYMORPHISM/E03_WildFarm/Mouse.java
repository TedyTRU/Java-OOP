package OOP.EX12_POLYMORPHISM.E03_WildFarm;

public class Mouse extends Mammal {

    public Mouse(String animalName, String animalType,
                 double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            throw new IllegalArgumentException
                    ("Mice are not eating that type of food!");

        } else {
            super.eat(food);
        }
    }

}
