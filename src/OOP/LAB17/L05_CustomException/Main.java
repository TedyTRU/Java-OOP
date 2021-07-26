package OOP.LAB17.L05_CustomException;

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
