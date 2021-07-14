package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.enumeration.Corps;
import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Commando;
import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Mission;

import java.util.Collection;
import java.util.Set;
import java.util.TreeSet;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {

    private Set<Mission> missions;

    public CommandoImpl(int id, String firstName, String lastName, double salary, Corps corps) {
        super(id, firstName, lastName, salary, corps);
        this.missions = new TreeSet<>();
    }

    @Override
    public Collection<Mission> getMissions() {
        return this.missions;
    }

    @Override
    public void addMission(Mission mission) {
        this.missions.add(mission);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString()).append(System.lineSeparator());
        sb.append(String.format("Corps: %s", getCorps())).append(System.lineSeparator());
        sb.append("Missions:");

        this.missions.forEach(m -> sb.append(m).append(System.lineSeparator()));

        return sb.toString().trim();
    }
}
