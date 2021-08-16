package OOP.LAB17.EXCEPTIONS_AND_ERROR_HANDLING.L04_ValidPerson;

public class Main {
    public static void main(String[] args) {

        try {
            Person person = new Person("Franco", "Aimee", 19);

            Person noName = new Person(" ", "Aimee", 19);
            Person noLastName = new Person("Franco", null, 19);
            Person negativeAge = new Person("Franco", "Aimee", -19);
            Person tooOldForThisProgram = new Person("Franco", "Aimee", 121);

        } catch (IllegalArgumentException e) {
            System.out.println("Exception thrown: " + e.getMessage());
        }

        System.out.println();

    }
}
