package OOP.LAB09_INTERFACES_AND_ABSTRACTION.L04_SayHelloExtended;

public abstract class BasePerson implements Person{
    private String name;

    protected BasePerson (String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String sayHello() {
        return "Hello";
    }

    private void setName( String name) {
        this.name = name;
    }

}
