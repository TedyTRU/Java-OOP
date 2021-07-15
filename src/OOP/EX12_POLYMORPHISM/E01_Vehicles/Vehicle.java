package OOP.EX12_POLYMORPHISM.E01_Vehicles;

import java.text.DecimalFormat;

public class Vehicle implements IVehicle {
    private double fuelQuantity;
    private double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        setFuelConsumption(fuelConsumption);
    }

    public void setFuelConsumption(double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    @Override
    public String drive(double distance) {
        double fuelNeed = distance * this.fuelConsumption;

        DecimalFormat df = new DecimalFormat("#.##");
        String result = "needs refueling";

        if (this.fuelQuantity >= fuelNeed) {
            result = String.format("travelled %s km", df.format(distance));
            this.fuelQuantity -= fuelNeed;
        }
        return result;
    }

    @Override
    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    @Override
    public String toString() {
        return String.format("%s: %.2f", this.getClass().getSimpleName(),
                this.fuelQuantity);
    }
}
