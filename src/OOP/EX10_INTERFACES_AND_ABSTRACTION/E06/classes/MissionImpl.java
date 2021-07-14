package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.classes;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.enumeration.MissionState;
import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces.Mission;

public class MissionImpl implements Mission {

    private String codeName;
    private MissionState state;

    public MissionImpl(String codeName, MissionState state) {
        this.codeName = codeName;
        this.state = state;
    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public MissionState getMissionState() {
        return this.state;
    }

    @Override
    public MissionState completeMission() {
        return this.state = MissionState.FINISHED;
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s"
        , this.getCodeName(), getMissionState());
    }

}
