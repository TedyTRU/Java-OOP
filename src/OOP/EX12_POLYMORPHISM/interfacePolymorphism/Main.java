package OOP.EX12_POLYMORPHISM.interfacePolymorphism;

public class Main {
    public static void main(String[] args) {

        Eatable eatable = new Cake();
        System.out.println(eatable.getCalories());

        eatable = new Apple();
        System.out.println(eatable.getCalories());

    }
}
