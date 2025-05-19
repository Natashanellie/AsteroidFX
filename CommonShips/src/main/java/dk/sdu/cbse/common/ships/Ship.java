package dk.sdu.cbse.common.ships;

import dk.sdu.cbse.common.data.Entity;

public class Ship extends Entity {

    private int health;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int amount){
        this.health -= amount;
    }

    public boolean isDead(){
        return this.health <= 0;
    }





}
