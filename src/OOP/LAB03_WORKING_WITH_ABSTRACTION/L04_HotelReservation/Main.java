package OOP.LAB03_WORKING_WITH_ABSTRACTION.L04_HotelReservation;

import OOP.IOUtils.ConsoleReader;
import OOP.IOUtils.InputParser;

public class Main {
    public static void main(String[] args) {

        runHoliday();

    }

    private static void runHoliday() {
        ConsoleReader reader = new ConsoleReader();
        String input = reader.readLine();
        String[] tokens = InputParser.parseArray(input);

        PriceCalculator calculator = new PriceCalculator(
                Double.parseDouble(tokens[0]), Integer.parseInt(tokens[1]),
                tokens[3].endsWith("SecondVisit")
                        ? DiscountType.SECOND_VISIT
                        : DiscountType.valueOf(tokens[3].toUpperCase()),
                Season.valueOf(tokens[2].toUpperCase()));

        System.out.printf("%.2f%n", calculator.calculate());

    }
}
