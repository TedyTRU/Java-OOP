package OOP.EX06_ENCAPSULATION.E01_ClassBoxDataValidation;

public class Box {

    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
//        if (length <= 0) {
//            throw new IllegalStateException("Length cannot be zero or negative.");
//        }
//        this.length = length;
//        if (width <= 0) {
//            throw new IllegalStateException("Width cannot be zero or negative.");
//        }
//        this.width = width;
//        if (height <= 0) {
//            throw new IllegalStateException("Height cannot be zero or negative.");
//        }
//        this.height = height;

        this.setLength(length);
        this.setWidth(width);
        this.setHeight(height);
    }

    private void setLength(double length) {
        if (isPositive(length)) {
            this.length = length;
        }
    }

    private void setWidth(double width) {
        if (isPositive(width)) {
            this.width = width;
        }
    }

    private void setHeight(double height) {
        if (isPositive(height)) {
            this.height = height;
        }
    }

    private boolean isPositive(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Width cannot be zero or negative.");
        }
        return true;
    }

    public double calculateSurfaceArea() {
        return (2 * this.length * this.width) +
                (2 * this.length * this.height) +
                (2 * this.width * this.height);
    }

    public double calculateLateralSurfaceArea() {
        return (2 * this.length * this.height) +
                (2 * this.width * this.height);
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }

}
