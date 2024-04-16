package GamePlay;

import Job.*;
import Monster.*;

public class Battle {
    public static int battle(String[] getChar, int[] getStatus, int playerDice, Monster m, int mobDice) {
        int check;

        while (true) {
            if (playerDice > mobDice) {
                System.out.printf("나의 주사위: %d, 상대의 주사위: % d\n", playerDice, mobDice);
                System.out.println("선공입니다.\n\n");
                while (true) {
                    check = jobSkillChoice(getChar[2], getStatus, m);
                    if (check == -1 || check == -2) {      //check=-2 : 게임 오버, check=-1 : 통과
                        return check;
                    }
                    check = monsterSkill(m, getStatus);
                    if (check == -1 || check == -2) {
                        return check;
                    }
                }
            } else if (playerDice < mobDice) {
                System.out.printf("나의 주사위: %d, 상대의 주사위: % d\n", playerDice, mobDice);
                System.out.println("후공입니다.\n\n");
                while (true) {
                    check = monsterSkill(m, getStatus);
                    if (check == -1 || check == -2) {
                        return check;
                    }
                    check = jobSkillChoice(getChar[2], getStatus, m);
                    if (check == -1 || check == -2) {
                        return check;
                    }
                }
            }
        }
    }

    public static int jobSkillChoice(String inputJob, int[] getStatus, Monster m) {
        if (getStatus[1] <= 0) {
            return -2;
        }
        Job job;
        int damage;
        int successCheck;
        Function.statusInfo(getStatus);
        if (inputJob.equals("검사")) {
            job = new Swordsman();
            int choice = job.jobSkillMenu();
            switch (choice) {
                case 1:
                    damage = job.skillAttack(getStatus);
                    m.setNowHP(m.getNowHP() - damage);
                    return 0;

                case 2:
                    damage = job.skillMp(getStatus);
                    m.setNowHP(m.getNowHP() - damage);
                    return 0;

                case 3:
                    damage = job.skillSpecial(getStatus);
                    m.setNowHP(m.getNowHP() - damage);
                    return 0;

                case 4:
                    successCheck = job.skillRun();
                    return successCheck;
            }
        } else if (inputJob.equals("방패병")) {
            job = new Tanker();
            int choice = job.jobSkillMenu();
            switch (choice) {
                case 1:
                    damage = job.skillAttack(getStatus);
                    m.setNowHP(m.getNowHP() - damage);
                    return 0;

                case 2:
                    job.skillMp(getStatus);
                    return 0;

                case 3:
                    job.skillSpecial(getStatus);
                    return 0;

                case 4:
                    successCheck = job.skillRun();
                    return successCheck;
            }
        } else if (inputJob.equals("법사")) {
            job = new Wizard();
            int choice = job.jobSkillMenu();
            switch (choice) {
                case 1:
                    damage = job.skillAttack(getStatus);
                    m.setNowHP(m.getNowHP() - damage);
                    return 0;

                case 2:
                    damage = job.skillMp(getStatus);
                    m.setNowHP(m.getNowHP() - damage);
                    return 0;

                case 3:
                    job.skillSpecial(getStatus);
                    return 0;

                case 4:
                    successCheck = job.skillRun();
                    return successCheck;
            }
        }
        return -3;      // 직업 선택 또는 직업을 읽어오는 것에 에러 생겼을 경우 -3 리턴
    }

    public static int monsterSkill(Monster m, int[] getStatus) {
        if (m.getNowHP() <= 0) {
            m.monsterDie(getStatus);
            return -1;
        } else {
            m.monsterStat();
            m.monsterAttack(getStatus);
            return 0;
        }
    }
}
