package OOP.EX08_INHERITANCE.E04_NeedForSpeed;

public class Main {
    public static void main(String[] args) {

        Vehicle vehicle = new Vehicle(30.5, 110);

        Car car = new Car(20.3, 190);

        SportCar sportCar = new SportCar(60, 200);

        CrossMotorcycle crossMotorcycle = new CrossMotorcycle(50, 150);

        FamilyCar familyCar = new FamilyCar(50, 50);

        System.out.println(vehicle.getFuelConsumption());
        System.out.println(car.getFuelConsumption());
        System.out.println(crossMotorcycle.getFuelConsumption());

        System.out.println(sportCar.getFuelConsumption());
        System.out.println(familyCar.getFuelConsumption());


        car.drive(10);
        System.out.println(car.getFuel());

    }
}
