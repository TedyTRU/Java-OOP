package OOP.EX10_INTERFACES_AND_ABSTRACTION.E07_CollectionHierarchy.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E07_CollectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection implements MyList {
    @Override
    public int getUsed() {
        return this.items.size();
    }

    @Override
    public String remove() {
        return this.items.remove(0);
    }

    @Override
    public int add(String item) {
        this.items.add(0, item);
        return 0;
    }
}
