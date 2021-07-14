package OOP.EX10_INTERFACES_AND_ABSTRACTION.E07_CollectionHierarchy.classes;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {

    protected final int MAXSIZE = 100;
    protected List<String> items;

    public Collection() {
        this.items = new ArrayList<>(MAXSIZE);
    }

}
