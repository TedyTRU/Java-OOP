package bakery.repositories.interfaces;

import bakery.entities.tables.interfaces.BaseTable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class TableRepositoryImpl implements TableRepository<BaseTable> {
    private Collection<BaseTable> models;

    public TableRepositoryImpl() {
        this.models = new ArrayList<>();
    }

    @Override
    public BaseTable getByNumber(int number) {
        return this.models.stream().filter(b -> b.getTableNumber() == number).findFirst().orElse(null);
    }

    @Override
    public Collection<BaseTable> getAll() {
        return Collections.unmodifiableCollection(this.models);
    }

    @Override
    public void add(BaseTable baseTable) {
        this.models.add(baseTable);
    }
}
