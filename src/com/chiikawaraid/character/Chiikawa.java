package com.chiikawaraid.character;

import com.chiikawaraid.common.ActionResult;
import com.chiikawaraid.common.GameBalance;

public class Chiikawa extends Player {
   public Chiikawa() {
       super("치이카와", GameBalance.CHIIKAWA_MAX_HP, GameBalance.CHIIKAWA_BASE_ATTACK);
   }

   @Override
   public int getAttackPower() {
       return getBaseAttack()
               + getEnhancementLevel() * GameBalance.ATTACK_PER_ENHANCEMENT;
   }
    @Override
    public ActionResult useSkill(int skillNumber) {
        int attack = getAttackPower();

        switch (skillNumber) {
            case 1:
                return new ActionResult(
                        true,
                        "토벌봉 휘두르기!",
                        attack + GameBalance.SKILL_ONE_DAMAGE_BONUS,
                        0, 0, 0
                );

            case 2:
                if (!spendMp(GameBalance.SKILL_TWO_MP_COST)) {
                    return new ActionResult(
                            false, "MP가 부족합니다.", 0, 0, 0, 0
                    );
                }

                return new ActionResult(
                        true,
                        "용기 내어 강타!",
                        attack * GameBalance.SKILL_TWO_DAMAGE_MULTIPLIER
                                + GameBalance.SKILL_TWO_DAMAGE_BONUS,
                        0, 0, 0
                );

            case 3:
                if (!spendMp(GameBalance.SKILL_THREE_MP_COST)) {
                    return new ActionResult(
                            false, "MP가 부족합니다.", 0, 0, 0, 0
                    );
                }

                return new ActionResult(
                        true,
                        "작은 방패의 용기!",
                        attack,
                        0, 0,
                        GameBalance.CHIIKAWA_DAMAGE_REDUCTION_PERCENT
                );

            default:
                return new ActionResult(
                        false, "잘못된 스킬 번호입니다.", 0, 0, 0, 0
                );
        }
    }
}
