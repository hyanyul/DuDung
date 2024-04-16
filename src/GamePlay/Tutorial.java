package GamePlay;

import Monster.*;
import GamePlay.*;
import Job.*;

public class Tutorial {
    public static void tutoBattle(String[] getChar, int[] getStatus, Monster m, int[] saveStatus){

        while(true) {
            System.out.println("\n~~<전투 시작>~~");

            Function.timeSleep(1000);

            System.out.println("\n주사위를 굴려 선후공을 정합니다.\n");
            int playerDice;
            int mobDice;
            do {
                playerDice = Function.dice();
                mobDice = Function.dice();

            } while (playerDice == mobDice);

            Function.timeSleep(200);

            int check = Battle.battle(getChar, getStatus, playerDice, m, mobDice);

            Function.timeSleep(300);
            
            if(check == -1){
                Job.levelPlus(getStatus);
                break;
            } else if (check == -2) {
                System.out.println("\n~~<게임 오버>~~");
                System.out.println("\n튜토리얼을 다시 시작합니다.");
                getStatus = saveStatus;
                m = new TutorialMonster();
            }
        }

        Function.timeSleep(300);

        System.out.println("\n\n튜토리얼이 끝났습니다.");
    }
}
