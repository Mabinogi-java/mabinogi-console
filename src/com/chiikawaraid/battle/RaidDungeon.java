package com.chiikawaraid.battle;
import com.chiikawaraid.BattleResult;
import com.chiikawaraid.character.Player;
import java.util.Scanner;

public class RaidDungeon {
    public static void enter(Player player, Scanner sc) {

        RaidBoss boss = new RaidBoss();

        BattleResult result = BattleService.battle(player, boss, sc);

        if (result == BattleResult.WIN) {
            System.out.println("세이렌 토벌 성공!");
        } else if (result == BattleResult.LOSE) {
            System.out.println("세이렌 토벌에 실패했습니다.");
        } else if (result == BattleResult.ESCAPE) {
            System.out.println("세이렌 토벌에서 도망쳤습니다.");
        }

    }
}
