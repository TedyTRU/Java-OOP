package EXAMS.E07.restaurant.entities.tables;

import EXAMS.E07.restaurant.entities.drinks.interfaces.Beverages;
import EXAMS.E07.restaurant.entities.healthyFoods.interfaces.HealthyFood;
import EXAMS.E07.restaurant.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static EXAMS.E07.restaurant.common.ExceptionMessages.*;

public abstract class BaseTable implements Table {
    private Collection<HealthyFood> healthyFood;
    private Collection<Beverages> beverages;
    private int number;
    private int size;
    private int numberOfPeople;
    private double pricePerPerson;
    private boolean isReservedTable;
    private double allPeople;

    protected BaseTable(int number, int size, double pricePerPerson) {
        this.number = number;
        this.setSize(size);
        this.pricePerPerson = pricePerPerson;
        this.healthyFood = new ArrayList<>();
        this.beverages = new ArrayList<>();
        this.isReservedTable = false;
    }

    private void setSize(int size) {
        if (size < 0) {
            throw new IllegalArgumentException(INVALID_TABLE_SIZE);
        }
        this.size = size;
    }

    private void setNumberOfPeople(int numberOfPeople) {
        if (numberOfPeople <= 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public int getTableNumber() {
        return this.number;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public int numberOfPeople() {
        return this.numberOfPeople;
    }

    @Override
    public double pricePerPerson() {
        return this.pricePerPerson;
    }

    @Override
    public boolean isReservedTable() {
        return this.isReservedTable;
    }

    @Override
    public double allPeople() {
        return this.numberOfPeople * this.pricePerPerson;
    }

    @Override
    public void reserve(int numberOfPeople) {
        setNumberOfPeople(numberOfPeople);
        this.isReservedTable = true;
    }

    @Override
    public void orderHealthy(HealthyFood food) {
        this.healthyFood.add(food);
    }

    @Override
    public void orderBeverages(Beverages beverages) {
        this.beverages.add(beverages);
    }

    @Override
    public double bill() {
        double sumOfFoods = this.healthyFood.stream().mapToDouble(HealthyFood::getPrice).sum();
        double sumOfDrinks = this.beverages.stream().mapToDouble(Beverages::getPrice).sum();

        return (numberOfPeople * pricePerPerson) + sumOfDrinks + sumOfFoods;
    }

    @Override
    public void clear() {
        this.healthyFood.clear();
        this.beverages.clear();
        this.isReservedTable = false;
        this.numberOfPeople = 0;
        //this.pricePerPerson = 0;
    }

    @Override
    public String tableInformation() {


        return String.format("Table - %d%nSize - %d%nType - %s%nAll price - %.2f%n",
                this.number, this.size, this.getClass().getSimpleName(), this.pricePerPerson);
    }

    public Collection<HealthyFood> getHealthyFood() {
        return this.healthyFood;
    }

    public Collection<Beverages> getBeverages() {
        return this.beverages;
    }
}
