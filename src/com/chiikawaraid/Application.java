package com.chiikawaraid;

import com.chiikawaraid.character.Chiikawa;
import com.chiikawaraid.character.Hachiware;
import com.chiikawaraid.character.Player;
import com.chiikawaraid.character.Usagi;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        System.out.println("치이카와 원정대 : 세이렌 토벌\n환영합니다.\n");

        Scanner sc= new Scanner(System.in);

        System.out.println("시작하려면 Enter를 누르세요.");

        sc.nextLine();

        System.out.println("플레이할 캐릭터의 번호를 선택하세요.");
        System.out.println("1.치이카와(전사)\n 2.하치와레(궁수)\n 3.우사기(마법사)");

        boolean check =true;

        Player player = null;

        while(check) {
            int input = sc.nextInt();
            switch(input) {
                case 1:
                    System.out.println("전사를 선택하셨습니다.");
                    player = new Chiikawa();
                    check =false;
                    break;
                case 2:
                    System.out.println("궁수를 선택하셨습니다.");
                    player = new Hachiware();
                    check =false;
                    break;
                case 3:
                    System.out.println("마법사를 선택하셨습니다.");
                    check =false;
                    player = new Usagi();
                    break;
                default :
                    System.out.println("1번, 2번, 3번 중 하나의 선택부탁드립니다.");
            }
        }









    }
}
