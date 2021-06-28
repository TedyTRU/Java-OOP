package OOP.LAB03_WORKING_WITH_ABSTRACTION.L04_HotelReservation;

public enum DiscountType {

    VIP(20),
    SECOND_VISIT(10),
    NONE(0);

    private int percentage;

    DiscountType(int percentage) {
        this.percentage = percentage;
    }

    public int getPercentage() {
        return percentage;
    }
}
