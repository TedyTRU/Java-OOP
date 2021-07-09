package OOP.EX10_INTERFACES_AND_ABSTRACTION.E04_FoodShortage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Rebel> rebels = new HashMap<>();
        Map<String, Citizen> citizens = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());
        while (n-- > 0) {
            String[] info = scanner.nextLine().split("\\s+");
            String name = info[0];
            int age = Integer.parseInt(info[1]);

            if (info.length == 3) {
                String group = info[2];
                Rebel rebel = new Rebel(name, age, group);
                rebels.putIfAbsent(name, rebel);

            } else if (info.length == 4) {
                String id = info[2];
                String birthday = info[3];
                Citizen citizen = new Citizen(name, age, id, birthday);
                citizens.putIfAbsent(name, citizen);
            }

        }

        String names = scanner.nextLine();
        while (!"End".equals(names)) {

            if (rebels.containsKey(names)) {
                rebels.get(names).buyFood();
            }

            if (citizens.containsKey(names)) {
                citizens.get(names).buyFood();
            }

            names = scanner.nextLine();
        }

        int sum = 0;
        sum += rebels.values().stream().mapToInt(Rebel::getFood).sum();
        sum += citizens.values().stream().mapToInt(Citizen::getFood).sum();

        System.out.println(sum);

    }
}
