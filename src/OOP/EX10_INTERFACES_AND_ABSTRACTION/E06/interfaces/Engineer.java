package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces;

import java.util.Collection;
import java.util.Set;

public interface Engineer {

    void addRepair(Repair repair);

    Collection<Repair> getRepairs();

}
