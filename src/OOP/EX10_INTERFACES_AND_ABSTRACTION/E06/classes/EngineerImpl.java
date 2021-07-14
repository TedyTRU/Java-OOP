package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.enumeration.Corps;
import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Engineer;
import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Repair;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {

    private Set<Repair> repairs;

    public EngineerImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.repairs = new TreeSet<>();
    }

    @Override
    public void addRepair(Repair repair) {
        this.repairs.add(repair);
    }

    @Override
    public Collection<Repair> getRepairs() {
        return this.repairs;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Corps: %s", getCorps())).append(System.lineSeparator());
        sb.append("Repairs:").append(System.lineSeparator());

        this.repairs.forEach(r -> sb.append(r.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
