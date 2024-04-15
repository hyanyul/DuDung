package GamePlay;

import Monster.*;

import static GamePlay.Scenario.battle;

public class tutorial {

    public static void tutoBattle(String[] getChar, int[] getStatus, Monster m){

        while(true) {
            System.out.println("전투 시작");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("주사위를 굴려 선후공을 정합니다.");
            int playerDice = Dice.dice();
            int mobDice = Dice.dice();

            int check = battle(getChar, getStatus, playerDice, m, mobDice);
            
            if(check == -1){
                break;
            } else if (check == -2) {
                System.out.println("게임 오버");
                System.out.println("튜토리얼을 다시 시작합니다.");
            }
        }

        System.out.println("튜토리얼이 끝났습니다.");

         getStatus[8] = 1;
    }
}
