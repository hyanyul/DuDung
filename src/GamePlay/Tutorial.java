package GamePlay;

import Monster.*;
import GamePlay.*;
import Job.*;

public class Tutorial {
    
    // 튜토리얼 배틀
    public static int[] tutoBattle(String[] getChar, int[] getStatus, Monster m, int[] saveStatus){
        while(true) {
            System.out.println("\n~~<전투 시작>~~");

            Function.timeSleep(1000);

            System.out.println("\n주사위를 굴려 선후공을 정합니다.\n");
            int playerDice;
            int mobDice;
            
            // 둘의 주사위가 다른 눈금이 나올 때까지 반복
            do {
                playerDice = Function.dice();
                mobDice = Function.dice();

            } while (playerDice == mobDice);

            Function.timeSleep(200);

            // check: 배틀 결과
            int check = Battle.battle(getChar, getStatus, playerDice, m, mobDice);
            Function.timeSleep(300);
                
            if(check == -1){    // 게임 클리어
                Job.levelPlus(getStatus);
                break;
            } else if (check == -2) {       // 게임 오버
                System.out.println("\n~~<게임 오버>~~");
                System.out.println("\n튜토리얼을 다시 시작합니다.");

                getStatus = Function.saveStatus(saveStatus);    // 배틀로 변경된 스텟 저장
                m = new TutorialMonster();
            }
        }

        Function.timeSleep(300);

        System.out.println("\n\n튜토리얼이 끝났습니다!");

        Function.timeSleep(500);

        System.out.println("이제 정말 자유롭게 모험을 떠날 수 있겠네요!\n\n\n\n\n\n\n\n\n");

        Function.timeSleep(1000);

        System.out.println("물론 다음 스토리가 준비되면 말이죠\n\n\n\n\n\n\n\n\n\n");

        Function.timeSleep(100);

        return getStatus;   // 저장된 스텟 리턴
    }
}
