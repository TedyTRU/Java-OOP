package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (getBulletsPerBarrel() <= 0 && getTotalBullets() >= BULLETS_PER_BARREL) {
            reload();

        }
        if (getBulletsPerBarrel() > 0) {
            this.setBulletsPerBarrel(getBulletsPerBarrel() - 1);

        }
        return 1;
    }

    private void reload() {
        this.setTotalBullets(getTotalBullets() - BULLETS_PER_BARREL);
        this.setBulletsPerBarrel(BULLETS_PER_BARREL);
    }
}
