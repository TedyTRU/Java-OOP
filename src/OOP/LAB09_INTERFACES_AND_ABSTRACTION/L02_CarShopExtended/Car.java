package OOP.LAB09_INTERFACES_AND_ABSTRACTION.L02_CarShopExtended;

public interface Car {
    Integer TIRES = 4;

    public abstract String getModel();

    String getColor();

    Integer getHorsePower();

    String countryProduced();
}
