package GamePlay;

import GameCharacter.CreateCharacter;
import Monster.*;
import Job.*;

public class GamePlay {
    Scenario s = new Scenario();
    Monster m;
    LogSave ls = new LogSave();

    public void gamePlay(String id, String[] getChar, int[] getStatus){
        switch (getStatus[8]){
            case 0:
                s.start();
                getStatus[8] = 1;
                ls.logSave(id, getChar, getStatus);

            case 1:
                m = new TutorialMonster();
                s.tutorial(getChar, getStatus, new TutorialMonster());
                afterBattle(getStatus);
                getStatus[8] = 2;
                ls.logSave(id, getChar, getStatus);
        }
    }

    public static void afterBattle(int[] getStatus){
        getStatus[5] = getStatus[4];
    }
}
