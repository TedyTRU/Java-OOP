package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Repair;

public class RepairImpl implements Repair {

    private String partName;
    private int hoursWorked;

    public RepairImpl(String name, int hours) {
        this.partName = name;
        this.hoursWorked = hours;
    }

    @Override
    public String getPartName() {
        return this.partName;
    }

    @Override
    public int getHoursWorked() {
        return this.hoursWorked;
    }

    @Override
    public String toString() {
        return String.format("Part Name: %s Hours Worked: %d"
                , this.getPartName(), this.getHoursWorked());
    }
}
