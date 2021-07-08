package OOP.EX10_INTERFACES_AND_ABSTRACTION.E03_BirthdayCelebrations;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new HashMap<>();
        List<Person> peopleList = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] info = input.split("\\s+");
            String name = info[1];

            switch (info[0]) {
                case "Citizen":
                    int age = Integer.parseInt(info[2]);
                    String id = info[3];
                    String birthDay = info[4];

                    Citizen citizen = new Citizen(name, age, id, birthDay);
                    peopleList.add(citizen);
                    break;
                case "Pet":
                    String birthday = info[2];

                    Pet pet = new Pet(name, birthday);
                    //peopleList.add(pet);

                    //TODO

            }

            input = scanner.nextLine();
        }


    }
}
