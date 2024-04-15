package GamePlay;

import Job.*;
import Monster.*;
import GamePlay.*;

public class Scenario {
    //String[] getChar = {0.닉네임, 1.종족, 2.직업}
    // int[] getStatus = {0.최대 체력, 1.현재 체력, 2.기본 마나, 3.현재 마나, 4.기본 공격력, 5.현재 공격력, 6.경험치, 7.레벨, 8.진행도}

    Monster m = new TutorialMonster();

    public void start(){
        System.out.println("""
                ██████╗ ██╗   ██╗██████╗ ██╗   ██╗███╗   ██╗ ██████╗\s
                ██╔══██╗██║   ██║██╔══██╗██║   ██║████╗  ██║██╔════╝\s
                ██║  ██║██║   ██║██║  ██║██║   ██║██╔██╗ ██║██║  ███╗
                ██║  ██║██║   ██║██║  ██║██║   ██║██║╚██╗██║██║   ██║
                ██████╔╝╚██████╔╝██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝
                ╚═════╝  ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝\s
                """);
    }

    public void tutorial(String[] getChar, int[] getStatus, Monster m){
        System.out.println("당신은 모험을 떠나게 되었습니다.\n\n");

        timeSleep(2000);

        System.out.println("네? 너무 갑작스럽다구요? 앞뒤 설명은 없냐구요?\n");

        timeSleep(1000);

        System.out.println("어쩔 수 없습니다. 이미 모험은 시작되었고, 당신이 이 모험을 끝내기 위해서는 보스를 쓰러뜨려야만 합니다.\n\n");

        timeSleep(1000);

        System.out.println("마침 튜토리얼용으로 딱 좋은 몬스터가 나타났네요.\n 바로 전투해볼까요?");

        tutorial.tutoBattle(getChar, getStatus, m);

    }

    public static int battle(String[] getChar, int[] getStatus, int playerDice, Monster m, int mobDice) {
        int check;

        while(true) {
            if (playerDice > mobDice) {
                System.out.printf("나의 주사위: %d, 상대의 주사위: % d\n", playerDice, mobDice);
                System.out.println("선공입니다.");
                while (true) {
                    check = jobSkillChoice(getChar[2], getStatus, m);
                    if (check == -1 || check == -2) {
                        return check;
                    }
                    check = monsterSkill(m, getStatus);
                    if (check == -1 || check == -2) {
                        return check;
                    }
                }
            } else if (playerDice < mobDice){
                System.out.printf("나의 주사위: %d, 상대의 주사위: % d\n", playerDice, mobDice);
                System.out.println("후공입니다.");
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

    public static int jobSkillChoice(String inputJob, int[] getStatus, Monster m){
        if(getStatus[1] == 0){
            return -2;
        }
        Job job;
        int damage;
        int successCheck;
        if(inputJob.equals("검사")){
            job = new Swordsman();
            job.statusInfo(getStatus);
            int choice = job.jobSkillMenu();
            switch (choice){
                case 1:
                    damage = job.skillAttack(getStatus);
                    m.setNowHP(m.getNowHP()-damage);
                    return 0;

                case 2:
                    damage = job.skillMp(getStatus);
                    m.setNowHP(m.getNowHP()-damage);
                    return 0;

                case 3:
                    damage = job.skillSpecial(getStatus);
                    m.setNowHP(m.getNowHP()-damage);
                    return 0;

                case 4:
                    successCheck = job.skillRun();
                    return successCheck;
            }
        } else if(inputJob.equals("방패병")){
            job = new Tanker();
            job.statusInfo(getStatus);
            int choice = job.jobSkillMenu();
            switch (choice){
                case 1:
                    damage = job.skillAttack(getStatus);
                    m.setNowHP(m.getNowHP()-damage);
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
        } else if(inputJob.equals("법사")){
            job = new Wizard();
            job.statusInfo(getStatus);
            int choice = job.jobSkillMenu();
            switch (choice){
                case 1:
                    damage = job.skillAttack(getStatus);
                    m.setNowHP(m.getNowHP()-damage);
                    return 0;

                case 2:
                    damage = job.skillMp(getStatus);
                    m.setNowHP(m.getNowHP()-damage);
                    return 0;

                case 3:
                    job.skillSpecial(getStatus);
                    return 0;

                case 4:
                    successCheck = job.skillRun();
                    return successCheck;
            }
        }
        return -3;      // 직업 선택 또는 직업을 읽어오는 것에 에러 생겼을 경우 -2 리턴
    }

    public static int monsterSkill(Monster m, int[] getStatus){
        m.monsterStat();
        if (m.getNowHP() <= 0){
            m.monsterDie();
            return -1;
        } else {
            m.monsterAttack(getStatus);
            return 0;
        }
    }

    public static void timeSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}