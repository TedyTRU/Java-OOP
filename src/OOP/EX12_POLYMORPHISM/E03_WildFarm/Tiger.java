package OOP.EX12_POLYMORPHISM.E03_WildFarm;

public class Tiger extends Feline {
    private String livingRegion;

    public Tiger(String animalName, String animalType,
                 double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (!(food instanceof Meat)) {

            throw new IllegalArgumentException
                    ("Tigers are not eating that type of food!");

        } else {
            super.eat(food);
        }
    }

}
