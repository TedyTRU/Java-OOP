package EXAMS.E03.bakery.core;

import EXAMS.E03.bakery.common.enums.BakedFoodType;
import EXAMS.E03.bakery.common.enums.DrinkType;
import EXAMS.E03.bakery.common.enums.TableTYpe;
import EXAMS.E03.bakery.core.interfaces.Controller;
import EXAMS.E03.bakery.entities.bakedFoods.interfaces.BakedFood;
import EXAMS.E03.bakery.entities.bakedFoods.interfaces.*;
import EXAMS.E03.bakery.entities.drinks.interfaces.Drink;
import EXAMS.E03.bakery.entities.drinks.interfaces.Tea;
import EXAMS.E03.bakery.entities.drinks.interfaces.Water;
import EXAMS.E03.bakery.entities.tables.interfaces.InsideTable;
import EXAMS.E03.bakery.entities.tables.interfaces.OutsideTable;
import EXAMS.E03.bakery.entities.tables.interfaces.Table;
import EXAMS.E03.bakery.repositories.interfaces.*;

import static EXAMS.E03.bakery.common.ExceptionMessages.*;
import static EXAMS.E03.bakery.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private FoodRepository<BakedFood> foodRepository;
    private DrinkRepository<Drink> drinkRepository;
    private TableRepository<Table> tableRepository;

    private BakedFood food;
    private Drink drink;
    private Table table;
    private double bills;

    public ControllerImpl(FoodRepository<BakedFood> foodRepository,
                          DrinkRepository<Drink> drinkRepository,
                          TableRepository<Table> tableRepository) {
        this.foodRepository = foodRepository;
        this.drinkRepository = drinkRepository;
        this.tableRepository = tableRepository;
    }


    @Override
    public String addFood(String type, String name, double price) {

        if (foodRepository.getByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (BakedFoodType.valueOf(type)) {
            case Bread:
                food = new Bread(name, price);
                break;
            case Cake:
                food = new Cake(name, price);
                break;
        }
        foodRepository.add(food);

        return String.format(FOOD_ADDED, name, type);
    }

    @Override
    public String addDrink(String type, String name, int portion, String brand) {

        if (drinkRepository.getByNameAndBrand(name, brand) != null) {
            throw new IllegalArgumentException(String.format(FOOD_OR_DRINK_EXIST, type, name));
        }

        switch (DrinkType.valueOf(type)) {
            case Tea:
                drink = new Tea(name, portion, brand);
                break;
            case Water:
                drink = new Water(name, portion, brand);
                break;
        }
        drinkRepository.add(drink);

        return String.format(DRINK_ADDED, name, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        if (tableRepository.getByNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_EXIST, tableNumber));
        }

        switch (TableTYpe.valueOf(type)) {
            case InsideTable:
                table = new InsideTable(tableNumber, capacity);
                break;
            case OutsideTable:
                table = new OutsideTable(tableNumber, capacity);
                break;
        }
        tableRepository.add(table);

        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserveTable(int numberOfPeople) {

        table = tableRepository.getAll().stream()
                .filter(t -> !t.isReserved() && t.getCapacity() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderFood(int tableNumber, String foodName) {
        food = this.foodRepository.getByName(foodName);
        table = this.tableRepository.getByNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, foodName);
        }

        table.orderFood(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, tableNumber, foodName);
    }

    @Override
    public String orderDrink(int tableNumber, String drinkName, String drinkBrand) {
        drink = this.drinkRepository.getByNameAndBrand(drinkName, drinkBrand);
        table = this.tableRepository.getByNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, drinkName, drinkBrand);
        }

        table.orderDrink(drink);
        return String.format(DRINK_ORDER_SUCCESSFUL, tableNumber, drinkName, drinkBrand);
    }

    @Override
    public String leaveTable(int tableNumber) {
        table = this.tableRepository.getByNumber(tableNumber);
        double bill = table.getBill();
        this.bills += bill;
        table.clear();

        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String getFreeTablesInfo() {
        StringBuilder sb = new StringBuilder();
        this.tableRepository.getAll().stream()
                .filter(t -> !t.isReserved())
                .forEach(t -> sb.append(t.getFreeTableInfo()).append(System.lineSeparator()));

        return sb.toString().trim();
    }

    @Override
    public String getTotalIncome() {

        return String.format(TOTAL_INCOME, this.bills);
    }
}
