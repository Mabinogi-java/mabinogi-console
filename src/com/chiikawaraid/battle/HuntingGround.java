package com.chiikawaraid.battle;

import com.chiikawaraid.BattleResult;
import com.chiikawaraid.character.Player;
import com.chiikawaraid.common.ActionResult;

import java.util.Scanner;

public class HuntingGround {
    public static void hunt(Player player, Scanner sc) {

        System.out.println("사냥할 몬스터를 선택하세요.");
        System.out.println("1. 작은 몬스터\n 2. 큰 몬스터");
        int input = sc.nextInt();

        Monster monster;

        if(input==1) {
            monster = new SmallMonster();
        }else if(input==2) {
            monster = new BigMonster();
        }else {
            return;
        }

        BattleResult result = BattleService.battle(player, monster, sc);

        if (result == BattleResult.WIN) {
            System.out.println("몬스터를 처치하였습니다.");
            player.addGold(monster.getGold());

            System.out.println(monster.getGold() + "골드를 획득했습니다.");
        }
        if (result == BattleResult.ESCAPE) {
            System.out.println("전투에서 도망쳤습니다.");
        }

        if(player.isDead()) {
            System.out.println("사망하였습니다.");
        }
    }

}


