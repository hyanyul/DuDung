package GamePlay;

import GameCharacter.CreateCharacter;
import Monster.*;
import Job.*;

public class GamePlay {
    Scenario s = new Scenario();
    Monster m;
    LogSave ls = new LogSave();

    // 실행 파일에서 불러오는 게임 플레이 메소드
    public void gamePlay(String id, String[] getChar, int[] getStatus){
        // getStatus[8] = 진행도
        switch (getStatus[8]){
            // 진행도에 따라 시작점 달라짐
            case 0:
                s.start();

                getStatus[8] = 1;

                ls.logSave(id, getChar, getStatus);

            case 1:
                m = new TutorialMonster();
                getStatus = s.tutorial(getChar, getStatus, new TutorialMonster());

                afterBattle(getStatus);
                getStatus[8] = 2;

                ls.logSave(id, getChar, getStatus);

            case 2:
                System.out.println("\n\n~TO BE CONTINUE~\n\n");
        }
    }
    
    // 배틀 후 cp를 원래대로 되돌리는 메소드
    public static void afterBattle(int[] getStatus){
        getStatus[5] = getStatus[4];
    }
}
