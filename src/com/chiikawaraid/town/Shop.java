package com.chiikawaraid.town;

import com.chiikawaraid.character.Player;
import com.chiikawaraid.common.GameBalance;
import com.chiikawaraid.common.PotionType;

public class Shop {
    public boolean buyPotion(Player player, PotionType type) {
        if (player == null || type == null) {
            return false;
        }

        switch (type) {
            case HP:
                if (player.getHpPotionCount() >= GameBalance.MAX_POTION_COUNT_PER_TYPE) {
                    return false;
                }
                if (!player.spendGold(GameBalance.HP_POTION_PRICE)) {
                    return false;
                }
                player.setHpPotionCount(player.getHpPotionCount() + 1);
                return true;

            case MP:
                if (player.getMpPotionCount() >= GameBalance.MAX_POTION_COUNT_PER_TYPE) {
                    return false;
                }
                if (!player.spendGold(GameBalance.MP_POTION_PRICE)) {
                    return false;
                }
                player.setMpPotionCount(player.getMpPotionCount() + 1);
                return true;

            default:
                return false;
        }
    }
}
