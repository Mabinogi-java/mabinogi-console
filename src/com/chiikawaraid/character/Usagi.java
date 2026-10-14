package com.chiikawaraid.character;

import com.chiikawaraid.common.ActionResult;
import com.chiikawaraid.common.GameBalance;

public class Usagi extends Player {
    public Usagi() {
        super("우사기", GameBalance.USAGI_MAX_HP, GameBalance.USAGI_BASE_ATTACK);
    }

    @Override
    public ActionResult useSkill(int skillNumber) {
        int attack = getAttackPower();

        switch (skillNumber) {
            case 1:
                return new ActionResult(
                        true, "야하! 마법탄!",
                        attack + GameBalance.SKILL_ONE_DAMAGE_BONUS,
                        0, 0, 0
                );

            case 2:
                if (!spendMp(GameBalance.SKILL_TWO_MP_COST)) {
                    return new ActionResult(false, "MP가 부족합니다.", 0, 0, 0, 0);
                }
                return new ActionResult(
                        true, "우나! 간식 폭발!",
                        attack * GameBalance.SKILL_TWO_DAMAGE_MULTIPLIER
                                + GameBalance.SKILL_TWO_DAMAGE_BONUS,
                        0, 0, 0
                );

            case 3:
                if (getHp() >= getMaxHp()) {
                    return new ActionResult(false, "HP가 이미 가득 찼습니다.", 0, 0, 0, 0);
                }
                if (!spendMp(GameBalance.SKILL_THREE_MP_COST)) {
                    return new ActionResult(false, "MP가 부족합니다.", 0, 0, 0, 0);
                }
                //
                return new ActionResult(
                        true, "기운 나는 주문!", 0,
                        GameBalance.USAGI_SKILL_HP_RECOVERY, 0, 0
                );

            default:
                return new ActionResult(false, "잘못된 스킬 번호입니다.", 0, 0, 0, 0);
        }
    }
}
