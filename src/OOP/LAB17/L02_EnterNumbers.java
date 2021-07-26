package OOP.LAB17;

import java.util.Scanner;
import java.util.stream.IntStream;

public class L02_EnterNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String start = scanner.nextLine();
            String end = scanner.nextLine();

            try {
                printNumberRange(start, end);
                return;

            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }

    }

    private static void printNumberRange(String start, String end) {
        int startNum;
        int endNum;
        try {
            startNum = Integer.parseInt(start);
            endNum = Integer.parseInt(end);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1Invalid input, please enter new range.", e);
        }

        if (!(1 < startNum && startNum < endNum && endNum < 100)) {
            throw new IllegalArgumentException("2Invalid input, please enter new range.");
        }

        IntStream.rangeClosed(startNum, endNum)
                .forEach(System.out::println);
    }
}
