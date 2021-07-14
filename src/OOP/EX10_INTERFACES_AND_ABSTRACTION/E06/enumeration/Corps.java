package OOP.EX10_INTERFACES_AND_ABSTRACTION.E06.enumeration;

public enum Corps {

    AIRFORCES("Airforces"),
    MARINES("Marines");

    private String corps;

    Corps(String corps) {
        this.corps = corps;
    }

    public String getCorps() {
        return this.corps;
    }

    public static boolean isValidCorps(String corps) {
        return corps.equals(AIRFORCES.getCorps()) || corps.equals(MARINES.getCorps());
    }

}
