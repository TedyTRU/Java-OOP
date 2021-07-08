package OOP.LAB09_INTERFACES_AND_ABSTRACTION.L03_SayHello;

public interface Person {

    String getName();

    default String sayHello() {
      return "Hello";
    }

}
