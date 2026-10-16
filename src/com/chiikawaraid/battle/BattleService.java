package com.chiikawaraid.battle;

import com.chiikawaraid.BattleResult;
import com.chiikawaraid.character.Chiikawa;
import com.chiikawaraid.character.Hachiware;
import com.chiikawaraid.character.Usagi;
import com.chiikawaraid.common.ActionResult;
import com.chiikawaraid.character.Player;
import com.chiikawaraid.common.PotionType;
import java.util.Scanner;

public class BattleService {

    public static BattleResult battle(Player player, Monster monster, Scanner sc) {

        while(monster.isAlive() && !player.isDead()) {System.out.println("몬스터의 HP : "+monster.getHp());
            System.out.println("유저의 HP : "+player.getHp());
            System.out.println("유저의 MP :" + player.getMp());

            System.out.println("스킬을 선택하세요.");
            if (player instanceof Chiikawa) {
                System.out.println("1. 토벌봉 휘두르기");
                System.out.println("2. 용기 내어 강타");
                System.out.println("3. 작은 방패의 용기");
            }else if (player instanceof Hachiware) {
                System.out.println("1. 씩씩한 한 발!");
                System.out.println("2. 해냈다! 집중 사격!");
                System.out.println("3. 아슬아슬 회피 사격!");
            }else if (player instanceof Usagi) {
                System.out.println("1. 야하! 마법탄!");
                System.out.println("2. 우나! 간식 폭발!");
                System.out.println("3. 기운 나는 주문!");
            }

            System.out.println("4. 방어");
            System.out.println("5. 포션");
            System.out.println("6. 도망");

            int skillNumber = sc.nextInt();

            if(skillNumber==6) {
                return BattleResult.ESCAPE;
            }

            ActionResult result;

            if(skillNumber==4) {
                result=player.defend();
            }else if(skillNumber==5){
                System.out.println("1. HP 포션");
                System.out.println("2. MP 포션");

                int pointNumber = sc.nextInt();

                if(pointNumber==1){
                    result = player.usePotion(PotionType.HP);
                } else if (pointNumber==2) {
                    result = player.usePotion(PotionType.MP);
                }else {
                    System.out.println("잘못된 포션 선택입니다.");
                    continue;
                }

            } else {
                result = player.useSkill(skillNumber);
            }



            if(!result.isSuccess()){
                System.out.println("스킬을 다시 선택하세요.");
                System.out.println(result.getMessage());

                continue;
            }

            System.out.println(result.getMessage());
            if (result.getDamage() > 0) {
                System.out.println("몬스터에게 " + result.getDamage() + "의 피해를 입혔습니다.");
            }

            int beforeHp = player.getHp();
            int beforeMp = player.getMp();

            player.restoreMp(result.getMpRecovery());

            player.healHp(result.getHpRecovery());

            int recoveredHp = player.getHp() - beforeHp;
            int recoveredMp = player.getMp() - beforeMp;

            if (recoveredHp > 0) {
                System.out.println("HP " + recoveredHp + " 회복!");
            }

            if (recoveredMp > 0) {
                System.out.println("MP " + recoveredMp + " 회복!");
            }

            monster.takeDamage(result.getDamage());

            if(monster.isAlive()) {
                int damage = monster.getDamage() * (100 - result.getDamageReductionPercent()) / 100;
                player.takeDamage(damage);
                System.out.println("몬스터의 반격! " + player.getName() + "이(가) " + damage + "의 피해를 받았습니다.");
            }

        }
        if (!monster.isAlive()) {
            return BattleResult.WIN;
        } else {
            return BattleResult.LOSE;
        }
    }
}
