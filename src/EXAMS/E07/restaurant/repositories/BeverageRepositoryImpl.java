package EXAMS.E07.restaurant.repositories;

import EXAMS.E07.restaurant.entities.drinks.interfaces.Beverages;
import EXAMS.E07.restaurant.repositories.interfaces.BeverageRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BeverageRepositoryImpl implements BeverageRepository<Beverages> {
    private Collection<Beverages> entities;

    public BeverageRepositoryImpl() {
        this.entities = new ArrayList<>();
    }

    @Override
    public Beverages beverageByName(String drinkName, String drinkBrand) {
        return this.entities.stream()
                .filter(t -> t.getName().equals(drinkName) && t.getBrand().equals(drinkBrand))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Collection<Beverages> getAllEntities() {
        return Collections.unmodifiableCollection(this.entities);
    }

    @Override
    public void add(Beverages entity) {
        this.entities.add(entity);
    }
}
