package OOP.LAB23_DESIGN_PATTERNS.L01_Singleton;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, Integer> capitals = new HashMap<>();

        capitals.put("Sofia", 120000);
        capitals.put("Varna", 9000);

        SingletonDataContainer instance1 = SingletonDataContainer.getInstance();
        System.out.println(instance1.getPopulation(capitals, "Sofia"));

        SingletonDataContainer instance2 = SingletonDataContainer.getInstance();
        System.out.println(instance2.getPopulation(capitals, "Varna"));

        System.out.println(instance1.getPopulation(capitals, "Varna"));

    }
}
