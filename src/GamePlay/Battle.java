package GamePlay;

import Job.*;
import Monster.*;

public class Battle {
    
    // 주사위 숫자에 따라 선후공 정해서 몬스터와 플레이어가 턴에 따라 공격하도록 함
    public static int battle(String[] getChar, int[] getStatus, int playerDice, Monster m, int mobDice) {
        int check;

        while (true) {
            // 플레이어 주사위 숫자가 클 경우 플레이어 먼저 공격
            if (playerDice > mobDice) {
                System.out.printf("나의 주사위: %d, 상대의 주사위: % d\n\n", playerDice, mobDice);

                Function.timeSleep(300);

                System.out.println("선공입니다.\n\n");
                while (true) {
                    // check: 게임 끝났는지 확인 용도
                    // check = -2 : 게임 오버, check = -1 : 클리어
                    check = jobSkillChoice(getChar[2], getStatus, m);
                    if (check == -1 || check == -2) {
                        return check;
                    }

                    Function.timeSleep(300);

                    check = monsterSkill(m, getStatus);
                    if (check == -1) {
                        return check;
                    }
                }
            // 몬스터 주사위 숫자가 클 경우 몬스터 먼저 공격
            } else if (playerDice < mobDice) {
                System.out.printf("나의 주사위: %d, 상대의 주사위: % d\n\n", playerDice, mobDice);

                Function.timeSleep(300);

                System.out.println("후공입니다.\n\n");
                while (true) {
                    check = monsterSkill(m, getStatus);
                    if (check == -1) {
                        return check;
                    }

                    Function.timeSleep(300);

                    check = jobSkillChoice(getChar[2], getStatus, m);
                    if (check == -1 || check == -2) {
                        return check;
                    }
                }
            }
        }
    }

    // 직업에 따라 스킬이 다름
    // 직업에 따라 job에 배당하는 객체 바꿔서 스킬 사용할 수 있도록 함(상속 이용)
    public static int jobSkillChoice(String inputJob, int[] getStatus, Monster m) {
        if (getStatus[1] <= 0) {
            return -2;
        }
        Job job;    // 직업 객체 넣는 용도
        int damage; // 플레이어 데미지
        int successCheck;   // 도망치기 성공 여부 확인
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
                    if (getStatus[8] != 1) {    // 튜토리얼의 경우 도망 불가
                        successCheck = job.skillRun();
                        return successCheck;
                    } else{
                        System.out.println("튜토리얼에서는 도망칠 수 없습니다.\n");
                        return 0;
                    }
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
                    if (getStatus[8] != 1) {
                        successCheck = job.skillRun();
                        return successCheck;
                    } else{
                        System.out.println("튜토리얼에서는 도망칠 수 없습니다.");
                        return 0;
                    }
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
                    if (getStatus[8] != 1) {
                        successCheck = job.skillRun();
                        return successCheck;
                    } else{
                        System.out.println("튜토리얼에서는 도망칠 수 없습니다.");
                        return 0;
                    }
            }
        }
        return -3;      // 직업 선택 또는 직업을 읽어오는 것에 에러 생겼을 경우 -3 리턴
    }
    
    // 몬스터 공격
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
