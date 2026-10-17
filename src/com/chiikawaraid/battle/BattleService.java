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

        int turn = 1;

        while(monster.isAlive() && !player.isDead()) {System.out.println("몬스터의 HP : "+monster.getHp());
            System.out.println("현재 턴 : " + turn);
            int attackDamage = monster.getDamage();

            if (monster instanceof RaidBoss) {
                attackDamage = ((RaidBoss) monster).getAttackDamage(turn);
                System.out.println("세이렌의 다음 공격 : " + ((RaidBoss) monster).getAttackName(turn));
                System.out.println("예상 피해량 : " + attackDamage);
            }
            System.out.println("유저의 HP : "+player.getHp());
            System.out.println("유저의 MP :" + player.getMp());

            System.out.println("무기 강화 단계: +" + player.getEnhancementLevel());
            System.out.println("공격력: " + player.getAttackPower());

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

            while (!sc.hasNextInt()) {
                if (!sc.hasNext()) {
                    return BattleResult.ESCAPE;
                }
                System.out.println("int 범위의 정수를 입력해 주세요.");
                sc.next();
            }
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

                while (!sc.hasNextInt()) {
                    if (!sc.hasNext()) {
                        return BattleResult.ESCAPE;
                    }
                    System.out.println("int 범위의 정수를 입력해 주세요.");
                    sc.next();
                }
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
                System.out.println(monster.getName() + "에게 " + result.getDamage() + "의 피해를 입혔습니다.");            }

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
                int damage = attackDamage * (100 - result.getDamageReductionPercent()) / 100;                player.takeDamage(damage);
                System.out.println("몬스터의 반격! " + player.getName() + "이(가) " + damage + "의 피해를 받았습니다.");
            }
            turn++;

        }
        if (!monster.isAlive()) {
            return BattleResult.WIN;
        } else {
            return BattleResult.LOSE;
        }
    }
}
