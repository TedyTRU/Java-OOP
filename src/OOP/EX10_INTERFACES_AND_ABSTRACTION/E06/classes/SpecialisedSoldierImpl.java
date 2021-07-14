package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.enumeration.Corps;
import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {

    private Corps corps;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary);
        this.corps = corps;
    }

    @Override
    public String getCorps() {
        return this.corps.getCorps();
    }

    @Override
    public String toString() {
        return String.format("%s%nCorps: %s", super.toString(), this.getCorps());
    }

}
