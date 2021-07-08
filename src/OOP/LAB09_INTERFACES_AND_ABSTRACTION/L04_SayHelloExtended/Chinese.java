package OOP.LAB09_INTERFACES_AND_ABSTRACTION.L04_SayHelloExtended;

public class Chinese extends BasePerson {
    private String name;

    public Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
