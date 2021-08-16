package EXAMS.E04.viceCity.repositories.interfaces;

import EXAMS.E04.viceCity.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class GunRepository implements Repository<Gun> {
    private List<Gun> models;

    public GunRepository() {
        this.models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return Collections.unmodifiableList(this.models);
    }

    @Override
    public void add(Gun model) {
        if (this.find(model.getName()) == null) {
            this.models.add(model);
        }
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun find(String name) {
        return this.models.stream()
                .filter(g -> g.getName().equals(name))
                .findAny().orElse(null);
    }
}
