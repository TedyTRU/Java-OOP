package bakery.repositories.interfaces;

import bakery.entities.drinks.interfaces.BaseDrink;

import java.util.ArrayList;
import java.util.Collection;

public class DrinkRepositoryImpl implements DrinkRepository<BaseDrink> {
    private Collection<BaseDrink> models;

    public DrinkRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BaseDrink getByNameAndBrand(String drinkName, String drinkBrand) {
        return null;
    }

    @Override
    public Collection<BaseDrink> getAll() {
        return null;
    }

    @Override
    public void add(BaseDrink baseDrink) {

    }
}
