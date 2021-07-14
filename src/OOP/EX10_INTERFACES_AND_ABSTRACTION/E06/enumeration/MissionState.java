package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.enumeration;

public enum MissionState {

    INPROGRESS("inProgress"),
    FINISHED("Finished");

    private String missionState;

    MissionState (String missionState) {
        this.missionState = missionState;
    }

    public String getMissionState() {
        return this.missionState;
    }

    public static boolean isValidState(String missionState) {
        return missionState.equals(INPROGRESS.getMissionState()) ||
                missionState.equals(FINISHED.getMissionState());
    }

}
