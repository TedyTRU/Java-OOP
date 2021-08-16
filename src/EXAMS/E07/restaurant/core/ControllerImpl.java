package EXAMS.E07.restaurant.core;

import EXAMS.E07.restaurant.common.enums.BeveragesType;
import EXAMS.E07.restaurant.common.enums.HealthyFoodType;
import EXAMS.E07.restaurant.common.enums.TableType;
import EXAMS.E07.restaurant.core.interfaces.Controller;
import EXAMS.E07.restaurant.entities.drinks.Fresh;
import EXAMS.E07.restaurant.entities.drinks.Smoothie;
import EXAMS.E07.restaurant.entities.drinks.interfaces.Beverages;
import EXAMS.E07.restaurant.entities.healthyFoods.Salad;
import EXAMS.E07.restaurant.entities.healthyFoods.VeganBiscuits;
import EXAMS.E07.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import EXAMS.E07.restaurant.entities.tables.InGarden;
import EXAMS.E07.restaurant.entities.tables.Indoors;
import EXAMS.E07.restaurant.entities.tables.interfaces.Table;
import EXAMS.E07.restaurant.repositories.interfaces.*;

import static EXAMS.E07.restaurant.common.ExceptionMessages.*;
import static EXAMS.E07.restaurant.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private HealthFoodRepository<HealthyFood> healthFoodRepository;
    private BeverageRepository<Beverages> beverageRepository;
    private TableRepository<Table> tableRepository;

    private HealthyFood food;
    private Beverages drink;
    private Table table;
    private double bills;

    public ControllerImpl(HealthFoodRepository<HealthyFood> healthFoodRepository, BeverageRepository<Beverages> beverageRepository, TableRepository<Table> tableRepository) {
        this.healthFoodRepository = healthFoodRepository;
        this.beverageRepository = beverageRepository;
        this.tableRepository = tableRepository;
    }

    @Override
    public String addHealthyFood(String type, double price, String name) {

        switch (HealthyFoodType.valueOf(type)) {
            case Salad:
                food = new Salad(name, price);
                break;
            case VeganBiscuits:
                food = new VeganBiscuits(name, price);
                break;
        }

        if (healthFoodRepository.foodByName(name) != null) {
            throw new IllegalArgumentException(String.format(FOOD_EXIST, name));
        }

        this.healthFoodRepository.add(food);
        return String.format(FOOD_ADDED, name);
    }

    @Override
    public String addBeverage(String type, int counter, String brand, String name) {

        switch (BeveragesType.valueOf(type)) {
            case Fresh:
                drink = new Fresh(name, counter, brand);
                break;
            case Smoothie:
                drink = new Smoothie(name, counter, brand);
                break;
        }

        if (beverageRepository.beverageByName(name, brand) != null) {
            throw new IllegalArgumentException(String.format(BEVERAGE_EXIST, name));
        }

        this.beverageRepository.add(drink);
        return String.format(BEVERAGE_ADDED, type, brand);
    }

    @Override
    public String addTable(String type, int tableNumber, int capacity) {

        switch (TableType.valueOf(type)) {
            case Indoors:
                table = new Indoors(tableNumber, capacity);
                break;
            case InGarden:
                table = new InGarden(tableNumber, capacity);
                break;
        }

        if (tableRepository.byNumber(tableNumber) != null) {
            throw new IllegalArgumentException(String.format(TABLE_IS_ALREADY_ADDED, tableNumber));
        }

        tableRepository.add(table);
        return String.format(TABLE_ADDED, tableNumber);
    }

    @Override
    public String reserve(int numberOfPeople) {

        table = this.tableRepository.getAllEntities().stream()
                .filter(t -> !t.isReservedTable() && t.getSize() >= numberOfPeople)
                .findFirst()
                .orElse(null);

        if (table == null) {
            return String.format(RESERVATION_NOT_POSSIBLE, numberOfPeople);
        }

        table.reserve(numberOfPeople);
        return String.format(TABLE_RESERVED, table.getTableNumber(), numberOfPeople);
    }

    @Override
    public String orderHealthyFood(int tableNumber, String healthyFoodName) {
        food = this.healthFoodRepository.foodByName(healthyFoodName);
        table = this.tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (food == null) {
            return String.format(NONE_EXISTENT_FOOD, healthyFoodName);
        }

        table.orderHealthy(food);
        return String.format(FOOD_ORDER_SUCCESSFUL, healthyFoodName, tableNumber);
    }

    @Override
    public String orderBeverage(int tableNumber, String name, String brand) {
        drink = this.beverageRepository.beverageByName(name, brand);
        table = this.tableRepository.byNumber(tableNumber);

        if (table == null) {
            return String.format(WRONG_TABLE_NUMBER, tableNumber);
        }

        if (drink == null) {
            return String.format(NON_EXISTENT_DRINK, name, brand);
        }

        table.orderBeverages(drink);
        return String.format(BEVERAGE_ORDER_SUCCESSFUL, name, tableNumber);
    }

    @Override
    public String closedBill(int tableNumber) {
        table = tableRepository.byNumber(tableNumber);
        double bill = table.bill();
        this.bills += bill;
        table.clear();

        return String.format(BILL, tableNumber, bill);
    }

    @Override
    public String totalMoney() {

        return String.format(TOTAL_MONEY, bills);
    }
}
