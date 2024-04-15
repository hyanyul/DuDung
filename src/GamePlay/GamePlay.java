package GamePlay;

import Monster.*;
import Job.*;

public class GamePlay {
    Job j = new Job();
    Scenario s = new Scenario();
    Monster m;
    LogSave ls = new LogSave();

    public void gamePlay(String id, String[] getChar, int[] getStatus){
        switch (getStatus[8]){
            case 0:
                s.start();
//                ls.logSave(id, getChar, getStatus);
            case 1:
                m = new TutorialMonster();
                s.tutorial(getChar, getStatus, new TutorialMonster());
                j.levelPlus(getStatus);
//                ls.logSave(id, getChar, getStatus);
        }
    }
}
