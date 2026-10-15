package com.chiikawaraid.battle;

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

        while (monster.isAlive() && !player.isDead()) {

            System.out.println("몬스터의 HP : "+monster.getHp());
            System.out.println("유저의 HP : "+player.getHp());
            System.out.println("유저의 MP :" + player.getMp());

            System.out.println("스킬을 선택하세요.");
            int skillNumber = sc.nextInt();

            ActionResult result = player.useSkill(skillNumber);

            if(!result.isSuccess()){
                System.out.println("스킬을 다시 선택하세요.");

                continue;
            }

            System.out.println(result.getMessage());

            monster.takeDamage(result.getDamage());

            if(monster.isAlive()) {
                player.takeDamage(monster.getDamage()*(100-result.getDamageReductionPercent())/100);
            }        }

        if(!monster.isAlive()){
            System.out.println("몬스터를 처치하였습니다.");
            player.addGold(monster.getGold());
        }

        if(player.isDead()) {
            System.out.println("사망하였습니다.");
        }
    }

}


