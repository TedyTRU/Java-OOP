package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.interfaces;

import OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.enumeration.MissionState;

import java.util.Collection;

public interface Mission {

    String getCodeName();

    MissionState getMissionState();

    MissionState completeMission();

}
