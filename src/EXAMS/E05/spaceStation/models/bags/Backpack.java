package EXAMS.E05.spaceStation.models.bags;

import java.util.ArrayList;
import java.util.Collection;

public class Backpack implements Bag {
    private Collection<String> data;

    public Backpack() {
        this.data = new ArrayList<>();
    }

    @Override
    public Collection<String> getItems() {
        return this.data;
    }
}
