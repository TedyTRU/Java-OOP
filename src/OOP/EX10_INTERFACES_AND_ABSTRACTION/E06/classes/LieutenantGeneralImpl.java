package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.LieutenantGeneral;
import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Private;

import java.util.Set;
import java.util.TreeSet;

public class LieutenantGeneralImpl extends PrivateImpl implements LieutenantGeneral {

    private Set<Private> privates;

    public LieutenantGeneralImpl(int id, String firstName, String lastName, double salary) {
        super(id, firstName, lastName, salary);
        this.privates = new TreeSet<>();
    }

    @Override
    public Set getPrivate() {
        return this.privates;
    }

    @Override
    public void addPrivate(Private soldier) {
        this.privates.add(soldier);
    }

    @Override
    public double getSalary() {
        return super.getSalary();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString()).append(System.lineSeparator());
        sb.append("Privates:").append(System.lineSeparator());

        this.privates.forEach(s -> sb.append(s.toString()).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
