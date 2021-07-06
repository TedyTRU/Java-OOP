package OOP.EX08_INHERITANCE.E06_Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        List<Animal> animals = new ArrayList<>();

        while (!"Beast!".equals(input)) {
            String[] animalInfo = scanner.nextLine().split("\\s+");
            String name = animalInfo[0];
            int age = Integer.parseInt(animalInfo[1]);
            String gender = animalInfo[2];

            Animal animal = null;

            try {
                switch (input) {
                    case "Cat":
                        animal = new Cat(name, age, gender);
                        break;
                    case "Dog":
                        animal = new Dog(name, age, gender);
                        break;
                    case "Frog":
                        animal = new Frog(name, age, gender);
                        break;
                    case "Tomcat":
                        animal = new Tomcat(name, age);
                        break;
                    case "Kitten":
                        animal = new Kitten(name, age);
                        break;
                }

                animals.add(animal);

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            //Animal animal = new Animal(name, age, gender);

            input = scanner.nextLine();
        }

        animals.forEach(System.out::println);

    }
}
