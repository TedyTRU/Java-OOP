package OOP.EX12_POLYMORPHISM.E03_WildFarm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();
        Animal animal = null;


        while (!input.equals("End")) {
            String[] animalInfo = input.split("\\s+");
            String[] foodInfo = scanner.nextLine().split("\\s+");
            String foodType = foodInfo[0];
            int quantity = Integer.parseInt(foodInfo[1]);

            Food food = null;
            if (foodType.equals("Vegetable")) {
                food = new Vegetable(quantity);
            } else if (foodType.equals("Meat")) {
                food = new Meat(quantity);
            }

            if (animalInfo.length == 5) {
                animal = new Cat(animalInfo[1], animalInfo[0],
                        Double.parseDouble(animalInfo[2]), animalInfo[3], animalInfo[4]);

            } else if (animalInfo.length == 4) {

                switch (animalInfo[0]) {
                    case "Tiger":
                        animal = new Tiger(animalInfo[1], animalInfo[0],
                                Double.parseDouble(animalInfo[2]), animalInfo[3]);
                        break;

                    case "Zebra":
                        animal = new Zebra(animalInfo[1], animalInfo[0],
                                Double.parseDouble(animalInfo[2]), animalInfo[3]);
                        break;

                    case "Mouse":
                        animal = new Mouse(animalInfo[1], animalInfo[0],
                                Double.parseDouble(animalInfo[2]), animalInfo[3]);
                        break;

                }
            }

            animal.makeSound();

            try {
                animal.eat(food);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            animals.add(animal);

            input = scanner.nextLine();
        }

        for (Animal pet : animals) {
            System.out.println(pet.toString());
        }

    }
}
