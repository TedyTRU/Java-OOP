package CounterStriker.models.players;

import CounterStriker.models.guns.Gun;

import static CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {
    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.setAlive();
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    private void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    private void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setAlive() {
        isAlive = this.health > 0;
    }

    private void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        return this.health > 0;
    }

    @Override
    public void takeDamage(int points) {
        if (this.armor > 0) {
            this.armor -= points;

        } else if (this.health > 0) {
            this.health -= points;

        } else {
            isAlive = false;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s: %s", this.getClass().getSimpleName(), this.getUsername()))
                .append(System.lineSeparator())
                .append(String.format("--Health: %d", this.getHealth()))
                .append(System.lineSeparator())
                .append(String.format("--Armor: %d", this.getArmor()))
                .append(System.lineSeparator())
                .append(String.format("--Gun: %s", this.getGun().getName()));

        return sb.toString().trim();
    }
}
