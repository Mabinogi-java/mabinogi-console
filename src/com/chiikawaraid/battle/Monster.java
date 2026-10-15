package com.chiikawaraid.battle;

public abstract class Monster {
    protected String name;
    protected int hp;
    protected int damage;
    protected int gold;

    public Monster() {}

    public Monster(String name, int hp, int damage, int gold) {
        this.name = name;
        this.hp = hp;
        this.damage = damage;
        this.gold = gold;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void takeDamage(int damage) {
        hp-=damage;
    }

    public boolean isAlive() {
        if(hp>0) {
            return true;
        }else return false;

    }

}
