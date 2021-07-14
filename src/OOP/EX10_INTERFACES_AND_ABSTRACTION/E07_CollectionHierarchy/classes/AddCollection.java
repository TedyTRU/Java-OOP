package OOP.EX10_INTERFACES_AND_ABSTRACTION.E07_CollectionHierarchy.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E07_CollectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        this.items.add(item);
        return this.items.size() - 1;
    }

}
