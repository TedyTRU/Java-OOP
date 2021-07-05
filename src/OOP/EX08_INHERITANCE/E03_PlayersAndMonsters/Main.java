package OOP.EX08_INHERITANCE.E03_PlayersAndMonsters;

public class Main {
    public static void main(String[] args) {

        Knight knight = new Knight("Artur", 10);
        Elf elf = new Elf("Elfie", 5);

        System.out.println(knight.toString());
        System.out.println(elf.toString());


    }
}
