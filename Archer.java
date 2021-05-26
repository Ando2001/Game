package com.company;

public class Archer extends Warior{
    public Archer(int health){
        super();
        this.setHealth(health);
    }
    public String getName(){
        return "Archer";
    }
    @Override
    public void attack(Weapon weapon) {

    }
    @Override
    public void takeAttack(int demage) {
        this.setHealth(this.getHealth()-demage);
    }
}
