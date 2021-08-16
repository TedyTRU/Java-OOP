package OOP.LAB17.EXCEPTIONS_AND_ERROR_HANDLING;

import java.util.Scanner;

public class L01_SquareRoot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            double sqrt = sqrt(scanner);
            System.out.println(sqrt);
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("Good bye!");
        }
    }

    public static double sqrt(Scanner scanner) {
        String str = scanner.nextLine();

        for (char symbol : str.toCharArray()) {
            if (!Character.isDigit(symbol)) {
                throw new NumberFormatException("Invalid number");
            }
        }

        int number = Integer.parseInt(str);
        return Math.sqrt(number);
    }
}
