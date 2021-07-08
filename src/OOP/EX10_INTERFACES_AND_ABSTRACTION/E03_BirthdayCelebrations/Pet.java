package OOP.EX10_INTERFACES_AND_ABSTRACTION.E03_BirthdayCelebrations;

public class Pet implements Birthable {
    private String name;
    private String birthDay;

    public Pet(String name, String birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String getBirthDate() {
        return this.birthDay;
    }
}
