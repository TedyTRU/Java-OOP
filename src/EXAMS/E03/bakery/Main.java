package EXAMS.E03.bakery;

import EXAMS.E03.bakery.core.ControllerImpl;
import EXAMS.E03.bakery.core.EngineImpl;
import EXAMS.E03.bakery.core.interfaces.Controller;
import EXAMS.E03.bakery.entities.bakedFoods.interfaces.BakedFood;
import EXAMS.E03.bakery.entities.drinks.interfaces.Drink;
import EXAMS.E03.bakery.entities.tables.interfaces.Table;

import EXAMS.E03.bakery.io.ConsoleReader;
import EXAMS.E03.bakery.io.ConsoleWriter;
import EXAMS.E03.bakery.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {

        String a = " ";
        int a1 = a.length();
        FoodRepository<BakedFood> foodRepository = new FoodRepositoryImpl();
        DrinkRepository<Drink> drinkRepository = new DrinkRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();

        Controller controller = new ControllerImpl(foodRepository, drinkRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
