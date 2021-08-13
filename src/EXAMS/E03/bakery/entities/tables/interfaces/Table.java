package EXAMS.E03.bakery.entities.tables.interfaces;

import EXAMS.E03.bakery.entities.bakedFoods.interfaces.BakedFood;
import EXAMS.E03.bakery.entities.drinks.interfaces.Drink;

public interface Table {
    int getTableNumber();

    int getCapacity();

    int getNumberOfPeople();

    double getPricePerPerson();

    boolean isReserved();

    double getPrice();

    void reserve(int numberOfPeople);

    void orderFood(BakedFood food);

    void orderDrink(Drink drink);

    double getBill();

    void clear();

    String getFreeTableInfo();
}
