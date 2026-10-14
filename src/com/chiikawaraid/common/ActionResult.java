package com.chiikawaraid.common;

public class ActionResult {
    private final boolean success;
    private final String message;
    private final int damage;
    private final int hpRecovery;
    private final int mpRecovery;
    private final int damageReductionPercent;

    public ActionResult(boolean success, String message, int damage,
                        int hpRecovery, int mpRecovery,
                        int damageReductionPercent) {
        this.success = success;
        this.message = message;
        this.damage = damage;
        this.hpRecovery = hpRecovery;
        this.mpRecovery = mpRecovery;
        this.damageReductionPercent = damageReductionPercent;
    }

    public boolean isSuccess() { return success; }
    public String getMessage() { return message; }
    public int getDamage() { return damage; }
    public int getHpRecovery() { return hpRecovery; }
    public int getMpRecovery() { return mpRecovery; }
    public int getDamageReductionPercent() {
        return damageReductionPercent;
    }
}
