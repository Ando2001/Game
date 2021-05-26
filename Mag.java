package com.company;

public class Mag extends Warior {
    public Mag(int health){
        super();
        this.setHealth(health);
    }
    public String getName(){
        return "Wizzard";
    }
    @Override
    public void attack(Weapon weapon) {

    }
    @Override
    public void takeAttack(int demage) {
        this.setHealth(this.getHealth()-demage);
    }
}
