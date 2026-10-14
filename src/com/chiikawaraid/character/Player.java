package com.chiikawaraid.character;

import com.chiikawaraid.common.ActionResult;
import com.chiikawaraid.common.GameBalance;
import com.chiikawaraid.common.PotionType;

public abstract class Player {
    private String name;
    private int hp;
    private int maxHp;
    private int baseAttack;

    private int mp = GameBalance.MAX_MP;
    private int maxMp = GameBalance.MAX_MP;
    private int gold = GameBalance.START_GOLD;
    private int hpPotionCount = GameBalance.START_HP_POTION_COUNT;
    private int mpPotionCount = GameBalance.START_MP_POTION_COUNT;
    private int enhancementLevel = GameBalance.START_ENHANCEMENT_LEVEL;

    protected Player(String name, int maxHp, int baseAttack) {
        this.name = name;
        this.hp = maxHp;
        this.maxHp = maxHp;
        this.baseAttack = baseAttack;
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

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public void setBaseAttack(int baseAttack) {
        this.baseAttack = baseAttack;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        this.maxMp = maxMp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getHpPotionCount() {
        return hpPotionCount;
    }

    public void setHpPotionCount(int hpPotionCount) {
        this.hpPotionCount = hpPotionCount;
    }

    public int getMpPotionCount() {
        return mpPotionCount;
    }

    public void setMpPotionCount(int mpPotionCount) {
        this.mpPotionCount = mpPotionCount;
    }

    public int getEnhancementLevel() {
        return enhancementLevel;
    }

    public void setEnhancementLevel(int enhancementLevel) {
        this.enhancementLevel = enhancementLevel;
    }

    protected boolean spendMp(int amount) {
        if (amount < 0 || mp < amount) {
            return false;
        }

        mp -= amount;
        return true;
    }

    public void takeDamage(int damage) {
        if (damage > 0) {
            hp = Math.max(0, hp - damage);
        }
    }
    public void healHp(int amount) {
        if (amount > 0) {
            hp += Math.min(amount, maxHp - hp);
        }
    }
    public void restoreMp(int amount) {
        if (amount > 0) {
            mp += Math.min(amount, maxMp - mp);
        }
    }
    public void recoverFully() {
        hp = maxHp;
        mp = maxMp;
    }
    public boolean isDead() {
        return hp <= 0;
    }
    public void addGold(int amount) {
        if (amount > 0) {
            gold += amount;
        }
    }
    public boolean spendGold(int amount) {
        if (amount < 0 || gold < amount) {
            return false;
        }
        gold -= amount;
        return true;
    }
    public ActionResult usePotion(PotionType type) {
        if (type == null) {
            return new ActionResult(false, "잘못된 포션 종류입니다.", 0, 0, 0, 0);
        }

        switch (type) {
            case HP:
                if (hpPotionCount <= 0) {
                    return new ActionResult(false, "HP 포션이 없습니다.", 0, 0, 0, 0);
                }
                if (hp >= maxHp) {
                    return new ActionResult(false, "HP가 이미 가득 찼습니다.", 0, 0, 0, 0);
                }
                hpPotionCount--;
                return new ActionResult(true, "딸기우유를 마셨습니다!",
                        0, GameBalance.HP_POTION_RECOVERY, 0, 0);

            case MP:
                if (mpPotionCount <= 0) {
                    return new ActionResult(false, "MP 포션이 없습니다.", 0, 0, 0, 0);
                }
                if (mp >= maxMp) {
                    return new ActionResult(false, "MP가 이미 가득 찼습니다.", 0, 0, 0, 0);
                }
                mpPotionCount--;
                return new ActionResult(true, "달콤한 주스를 마셨습니다!",
                        0, 0, GameBalance.MP_POTION_RECOVERY, 0);

            default:
                return new ActionResult(false, "잘못된 포션 종류입니다.", 0, 0, 0, 0);
        }
    }
    public ActionResult defend() {
        return new ActionResult(true, "방어 자세를 취합니다!", 0, 0,
                GameBalance.DEFEND_MP_RECOVERY,
                GameBalance.DEFEND_DAMAGE_REDUCTION_PERCENT);
    }

    public int getAttackPower() {
        return baseAttack + enhancementLevel * GameBalance.ATTACK_PER_ENHANCEMENT;
    }
    public abstract ActionResult useSkill(int skillNumber);

}
