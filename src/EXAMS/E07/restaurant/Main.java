package EXAMS.E07.restaurant;

import EXAMS.E07.restaurant.core.ControllerImpl;
import EXAMS.E07.restaurant.core.EngineImpl;
import EXAMS.E07.restaurant.core.interfaces.Controller;
import EXAMS.E07.restaurant.entities.drinks.interfaces.Beverages;
import EXAMS.E07.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import EXAMS.E07.restaurant.entities.tables.interfaces.Table;
import EXAMS.E07.restaurant.io.ConsoleReader;
import EXAMS.E07.restaurant.io.ConsoleWriter;
import EXAMS.E07.restaurant.repositories.BeverageRepositoryImpl;
import EXAMS.E07.restaurant.repositories.HealthFoodRepositoryImpl;
import EXAMS.E07.restaurant.repositories.TableRepositoryImpl;
import EXAMS.E07.restaurant.repositories.interfaces.*;

public class Main {
    public static void main(String[] args) {
        // TODO: Optional - Create new instances for all repositories to test your code locally.

        HealthFoodRepository<HealthyFood> healthFoodRepository = new HealthFoodRepositoryImpl();
        BeverageRepository<Beverages> beverageRepository = new BeverageRepositoryImpl();
        TableRepository<Table> tableRepository = new TableRepositoryImpl();


        Controller controller = new ControllerImpl(healthFoodRepository, beverageRepository, tableRepository);

        ConsoleReader reader = new ConsoleReader();
        ConsoleWriter writer = new ConsoleWriter();
        EngineImpl engine = new EngineImpl(reader, writer, controller);
        engine.run();

    }
}
