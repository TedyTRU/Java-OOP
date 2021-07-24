package OOP.EX16_REFLECTION_AND_ANOTATION.Е03_BarracksWars_ANewFactory.units;

public class Pikeman extends AbstractUnit {

	private static final int PIKEMAN_HEALTH = 30;
	private static final int PIKEMAN_DAMAGE = 15;

	public Pikeman() {
		super(PIKEMAN_HEALTH, PIKEMAN_DAMAGE);
	}
}
