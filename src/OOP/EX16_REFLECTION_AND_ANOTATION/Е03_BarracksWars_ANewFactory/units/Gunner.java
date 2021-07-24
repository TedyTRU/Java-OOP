package OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.units;

public class Gunner extends AbstractUnit {

    private static final int GUNNER_HEALTH = 20;
    private static final int GUNNER_DAMAGE = 20;

    public Gunner() {
        super(GUNNER_HEALTH, GUNNER_DAMAGE);
    }

}
