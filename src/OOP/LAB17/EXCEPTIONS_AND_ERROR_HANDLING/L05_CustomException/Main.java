package OOP.LAB17.EXCEPTIONS_AND_ERROR_HANDLING.L05_CustomException;

public class Main {
    public static void main(String[] args) {

        try {

            Student student = new Student("2.32Franco", "test@test.com");

        } catch (InvalidPersonNameException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        System.out.println();

    }
}
