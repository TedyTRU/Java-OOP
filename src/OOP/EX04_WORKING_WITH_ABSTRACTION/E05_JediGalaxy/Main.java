package OOP.EX04_WORKING_WITH_ABSTRACTION.E05_JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = fillInitialMatrix(scanner);

        String command = scanner.nextLine();
        long stars = 0;

        while (!command.equals("Let the Force be with you")) {

            int[] playerCoordinates = readArray(command);
            int[] evilCoordinates = readArray(scanner.nextLine());

            getEvilsVector(matrix, evilCoordinates);
            stars = getPlayersVector(matrix, stars, playerCoordinates);

            command = scanner.nextLine();
        }

        System.out.println(stars);

    }

    private static long getPlayersVector(int[][] matrix, long stars, int[] coordinates) {
        int row = coordinates[0];
        int col = coordinates[1];

        while (row >= 0 && col < matrix[1].length) {
            if (row < matrix.length && col >= 0 && col < matrix[0].length) {
                stars += matrix[row][col];
            }
            col++;
            row--;
        }
        return stars;
    }

    private static void getEvilsVector(int[][] matrix, int[] coordinates) {
        int row = coordinates[0];
        int col = coordinates[1];

        while (row >= 0 && col >= 0) {
            if (row < matrix.length && col < matrix[0].length) {
                matrix[row][col] = 0;
            }
            row--;
            col--;
        }
    }

    private static int[][] fillInitialMatrix(Scanner scanner) {
        int[] dimensions = readArray(scanner.nextLine());
        int row = dimensions[0];
        int col = dimensions[1];

        int[][] matrix = new int[row][col];

        int value = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    private static int[] readArray(String command) {
        return Arrays.stream(command.split("\\s+")).mapToInt(Integer::parseInt).toArray();
    }
}