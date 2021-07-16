package OOP.EX12_POLYMORPHISM.E03_WildFarm;

public class Zebra extends Mammal {

    public Zebra(String animalName, String animalType,
                 double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("Zs");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Vegetable)) {
            throw new IllegalArgumentException
                    ("Zebras are not eating that type of food!");

        } else {
            super.eat(food);
        }
    }


}
