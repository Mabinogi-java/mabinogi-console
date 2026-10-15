package com.chiikawaraid.town;

import com.chiikawaraid.character.Player;
import com.chiikawaraid.common.GameBalance;

public class Smith {
    public boolean enhance(Player player) {
        if (player == null || player.getEnhancementLevel() >= GameBalance.MAX_ENHANCEMENT_LEVEL) {
            return false;
        }

        int cost;
        switch (player.getEnhancementLevel()) {
            case 0:
                cost = GameBalance.ENHANCEMENT_LEVEL_ONE_COST;
                break;
            case 1:
                cost = GameBalance.ENHANCEMENT_LEVEL_TWO_COST;
                break;
            case 2:
                cost = GameBalance.ENHANCEMENT_LEVEL_THREE_COST;
                break;
            default:
                return false;
        }

        if (!player.spendGold(cost)) {
            return false;
        }
        player.setEnhancementLevel(player.getEnhancementLevel() + 1);
        return true;
    }
}
