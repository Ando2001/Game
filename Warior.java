package com.company;

import java.util.Scanner;

public abstract class Warior {
    private int health;
    public abstract void attack(Weapon weapon);
    public abstract void takeAttack(int demage);
    private Weapon weapon;

    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public abstract String getName();

    }

