package com.company;

public class Swordsman extends Warior {
    public Swordsman(int health){
        super();
        this.setHealth(health);
    }
    public String getName(){
        return "Swordsman";
    }
    @Override
    public void attack(Weapon weapon) {

    }

    @Override
    public void takeAttack(int demage) {
        this.setHealth(this.getHealth()-demage);
    }
}
