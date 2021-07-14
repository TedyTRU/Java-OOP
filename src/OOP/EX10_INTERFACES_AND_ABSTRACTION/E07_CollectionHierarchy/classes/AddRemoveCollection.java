package OOP.EX10_INTERFACES_AND_ABSTRACTION.E07_CollectionHierarchy.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E07_CollectionHierarchy.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection implements AddRemovable {

    @Override
    public String remove() {
        return this.items.remove(this.items.size() - 1);
    }

    @Override
    public int add(String item) {
        this.items.add(0, item);
        return 0;
    }
}
