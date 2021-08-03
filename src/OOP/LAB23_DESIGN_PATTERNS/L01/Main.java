package OOP.LAB23_DESIGN_PATTERNS.L01;

public class Main {
    public static void main(String[] args) {
        SingletonContainer.init();
        PopulationTracker tracker = SingletonContainer.getTracker();

        tracker.add("Sofia", 10);
        tracker.add("Plovdiv", 100);

        readNewPopulationData();

        System.out.println();
    }

    public static void readNewPopulationData() {
        PopulationTracker tracker = SingletonContainer.getTracker();

        tracker.add("Sofia", 10);
        tracker.add("Plovdiv", 100);
    }
}
