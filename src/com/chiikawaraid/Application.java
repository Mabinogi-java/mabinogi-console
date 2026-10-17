package com.chiikawaraid;

import com.chiikawaraid.battle.HuntingGround;
import com.chiikawaraid.character.Chiikawa;
import com.chiikawaraid.character.Hachiware;
import com.chiikawaraid.character.Player;
import com.chiikawaraid.character.Usagi;
import com.chiikawaraid.battle.RaidDungeon;
import com.chiikawaraid.town.Shop;
import com.chiikawaraid.common.PotionType;
import com.chiikawaraid.town.Smith;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("치이카와 원정대 : 세이렌 토벌\n환영합니다.\n");

        Scanner sc = new Scanner(System.in);

        System.out.println("시작하려면 Enter를 누르세요.");

        sc.nextLine();

        System.out.println("플레이할 캐릭터의 번호를 선택하세요.");
        System.out.println("1.치이카와(전사)\n 2.하치와레(궁수)\n 3.우사기(마법사)");

        boolean check = true;

        Player player = null;

        while (check) {
            while (!sc.hasNextInt()) {
                if (!sc.hasNext()) {
                    return;
                }
                System.out.println("int 범위의 정수를 입력해 주세요.");
                sc.next();
            }
            int input = sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("전사를 선택하셨습니다.");
                    player = new Chiikawa();
                    check = false;
                    break;
                case 2:
                    System.out.println("궁수를 선택하셨습니다.");
                    player = new Hachiware();
                    check = false;
                    break;
                case 3:
                    System.out.println("마법사를 선택하셨습니다.");
                    check = false;
                    player = new Usagi();
                    break;
                default:
                    System.out.println("1번, 2번, 3번 중 하나의 선택부탁드립니다.");
            }
        }
        boolean next = true;

        Shop shop = new Shop();
        Smith smith = new Smith();

        while (next) {
            String nextStep = null;
//            번: 사냥
//            2번: 레이드//
//            3번: Shop/
//            4번: Smith//
//            5번: 무료 휴식//
//            6번: 캐릭터 정보 확인/
//            7번: 게임 종료

            System.out.println("다음 행동을 선택하십시오.");
            System.out.println("1. 사냥\n 2.레이드\n 3.Shop\n 4. Smith \n 5.Rest \n 6. 캐릭터 정보 확인 \n7. 게임 종료");

            while (!sc.hasNextInt()) {
                if (!sc.hasNext()) {
                    return;
                }
                System.out.println("int 범위의 정수를 입력해 주세요.");
                sc.next();
            }
            int nextSt = sc.nextInt();
            switch (nextSt) {
                case 1:
                    System.out.println("사냥을 선택하셨습니다.");
                    HuntingGround.hunt(player, sc);
                    break;
                case 2:
                    System.out.println("레이드를 선택하셨습니다.");
                    RaidDungeon.enter(player, sc);
                    break;
                case 3:
                    System.out.println("상점에 오신 것을 환영합니다.");
                    System.out.println("1. HP 포션");
                    System.out.println("2. MP 포션");
                    while (!sc.hasNextInt()) {
                        if (!sc.hasNext()) {
                            return;
                        }
                        System.out.println("int 범위의 정수를 입력해 주세요.");
                        sc.next();
                    }
                    int potionChoice = sc.nextInt();
                    if (potionChoice == 1) {
                        boolean success = shop.buyPotion(player, PotionType.HP);

                        if (success) {
                            System.out.println("HP 포션 구매 성공!");
                        } else {
                            System.out.println("HP 포션 구매 실패!");
                        }
                    } else if (potionChoice == 2) {
                        boolean success = shop.buyPotion(player, PotionType.MP);

                        if (success) {
                            System.out.println("MP 포션 구매 성공!");
                        } else {
                            System.out.println("MP 포션 구매 실패!");
                        }
                    } else {
                        System.out.println("올바른 포션 번호를 선택해 주세요.");
                    }
                    break;
                case 4:
                    System.out.println("대장간에 오신 것을 환영합니다.");
                    boolean success = smith.enhance(player);
                    if (success) {
                        System.out.println("무기 강화에 성공했습니다!");
                    } else {
                        System.out.println("무기 강화에 실패했습니다.");
                    }
                    break;
                case 5:
                    player.recoverFully();
                    System.out.println("휴식을 마쳤습니다. HP와 MP가 모두 회복되었습니다.");
                    break;
                case 6:
                    System.out.println("캐릭터 이름: " + player.getName());
                    System.out.println("HP: " + player.getHp() + " / " + player.getMaxHp());
                    System.out.println("MP: " + player.getMp() + " / " + player.getMaxMp());
                    System.out.println("골드: " + player.getGold());
                    System.out.println("HP 포션: " + player.getHpPotionCount() + "개");
                    System.out.println("MP 포션: " + player.getMpPotionCount() + "개");
                    System.out.println("무기 강화 단계: +" + player.getEnhancementLevel());
                    System.out.println("공격력: " + player.getAttackPower());
                    break;
                case 7:
                    System.out.println("게임을 종료합니다.");
                    next = false;
                    break;
                default:
                    System.out.println("올바른 메뉴 번호를 선택해 주세요.");
                    break;
            }
        }


    }
}
