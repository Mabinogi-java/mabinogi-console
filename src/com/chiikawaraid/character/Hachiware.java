package com.chiikawaraid.character;

import com.chiikawaraid.common.ActionResult;
import com.chiikawaraid.common.GameBalance;

public class Hachiware extends Player {
    public Hachiware() {
        super("하치와레", GameBalance.HACHIWARE_MAX_HP, GameBalance.HACHIWARE_BASE_ATTACK);
    }

    @Override
    public ActionResult useSkill(int skillNumber) {
        int attack = getAttackPower();

        switch (skillNumber) {
            case 1:
                return new ActionResult(
                        true, "씩씩한 한 발!",
                        attack + GameBalance.SKILL_ONE_DAMAGE_BONUS,
                        0, 0, 0
                );

            case 2:
                if (!spendMp(GameBalance.SKILL_TWO_MP_COST)) {
                    return new ActionResult(false, "MP가 부족합니다.", 0, 0, 0, 0);
                }
                return new ActionResult(
                        true, "해냈다! 집중 사격!",
                        attack * GameBalance.SKILL_TWO_DAMAGE_MULTIPLIER
                                + GameBalance.SKILL_TWO_DAMAGE_BONUS,
                        0, 0, 0
                );

            case 3:
                if (!spendMp(GameBalance.SKILL_THREE_MP_COST)) {
                    return new ActionResult(false, "MP가 부족합니다.", 0, 0, 0, 0);
                }
                return new ActionResult(
                        true, "아슬아슬 회피 사격!", attack,
                        0, 0, GameBalance.HACHIWARE_DAMAGE_REDUCTION_PERCENT
                );

            default:
                return new ActionResult(false, "잘못된 스킬 번호입니다.", 0, 0, 0, 0);
        }
    }
}
