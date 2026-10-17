package com.chiikawaraid.battle;

public class RaidBoss extends Monster{

    public RaidBoss() {
        super("세이렌", 300, 18, 0);
    }

    public int getAttackDamage(int turn) {
        if (hp <= 150) {
            if (turn % 3 == 0) {
                return 46;
            }
            return 24;
        }

        if (turn % 3 == 0) {
            return 40;
        }
        return 18;
    }

    public String getAttackName(int turn) {
        if (turn % 3 == 0) {
            return "거센 파도";
        } else if (turn % 3 == 2) {
            return "파도 모으기";
        }
        return "물보라";
    }
}
