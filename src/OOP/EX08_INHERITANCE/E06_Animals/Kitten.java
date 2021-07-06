package OOP.EX08_INHERITANCE.E06_Animals;

public class Kitten extends Cat{
    final static String KITTEN_GENDER = "Female";

    public Kitten(String name, int age) {
        super(name, age, KITTEN_GENDER);
    }

    @Override
    public String produceSound() {
        return "Meow";
    }
}
