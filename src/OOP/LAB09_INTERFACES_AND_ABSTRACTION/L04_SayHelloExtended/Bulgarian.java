package OOP.LAB09_INTERFACES_AND_ABSTRACTION.L04_SayHelloExtended;

public class Bulgarian extends BasePerson {
    private String name;

    public Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
