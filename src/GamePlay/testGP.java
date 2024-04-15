package GamePlay;

import Monster.*;

public class testGP {
    public static void main(String[] args) {
//        LogSave ls = new LogSave();
//
//        String[] c = {"saveTest", "SaveTest", "검사"};
//        int[] s = {0, 0, 0, 0, 0, 0, 0, 8 ,0};
//
//        ls.logSave("test", c, s);

        int[] s = {1, 2, 40, 4, 5, 6, 7, 8, 9};

        Scenario.jobSkillChoice("법사", s, new TutorialMonster());
    }
}
