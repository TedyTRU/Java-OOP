package OOP.LAB03_WORKING_WITH_ABSTRACTION.L04_HotelReservation;

public class PriceCalculator {

    private double pricePerDay;
    private int days;
    private DiscountType discountType;
    private Season season;

    public PriceCalculator(double pricePerDay, int days, DiscountType discountType, Season season) {
        this.pricePerDay = pricePerDay;
        this.days = days;
        this.discountType = discountType;
        this.season = season;
    }

    public double calculate() {
        return pricePerDay * days * season.getMultiplier() * (1.00 - discountType.getPercentage() / 100.00);
    }

}
