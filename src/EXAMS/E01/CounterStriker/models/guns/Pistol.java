package EXAMS.E01.CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int FIRED_BULLETS = 1;

    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (this.getBulletsCount() <= 0) {
            return super.fire();

        } else {
            this.setBulletsCount(this.getBulletsCount() - FIRED_BULLETS);
            return FIRED_BULLETS;
        }
    }

}
