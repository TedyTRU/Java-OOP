package OOP.EX12_POLYMORPHISM.inheritancePolymorhism;

public class Main {
    public static void main(String[] args) {

        Animal animal = new Cat();
        animal.makeSound(); // типът на референцията определя достъпът до методите
                            // типът на инстанцията определя кое тяло на метода ще се извика method invocation

        animal = new Dog();
        animal.makeSound();




    }
}
