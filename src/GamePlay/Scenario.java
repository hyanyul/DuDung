package GamePlay;

import Job.*;
import Monster.*;

public class Scenario {

    static TutorialMonster tm = new TutorialMonster();

    public void playerJob(){

    }

    public void start(String[] choiceCharArr){
        System.out.println("""
                ██████╗ ██╗   ██╗██████╗ ██╗   ██╗███╗   ██╗ ██████╗\s
                ██╔══██╗██║   ██║██╔══██╗██║   ██║████╗  ██║██╔════╝\s
                ██║  ██║██║   ██║██║  ██║██║   ██║██╔██╗ ██║██║  ███╗
                ██║  ██║██║   ██║██║  ██║██║   ██║██║╚██╗██║██║   ██║
                ██████╔╝╚██████╔╝██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝
                ╚═════╝  ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝\s
                """);
    }
    public void tutorial(String[] choiceCharArr){
        System.out.println("당신은 모험을 떠나게 되었습니다.\n\n");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("네? 너무 갑작스럽다구요? 앞뒤 설명은 없냐구요?");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("어쩔 수 없습니다. 이미 모험은 시작되었고, 당신이 이 모험을 끝내기 위해서는 보스를 쓰러뜨려야만 합니다.\n");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("마침 튜토리얼용으로 딱 좋은 몬스터가 나타났네요. 바로 전투해볼까요?");

    }

    public static void tutoBattle(String[] choiceCharArr){
        System.out.println("전투 시작");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("주사위를 굴려 선후공을 정합니다.");
        int playerDice = Dice.dice();
        int mobDice = Dice.dice();

        battle(choiceCharArr, playerDice, tm, mobDice);

    }

    public static void battle(String[] choiceCharArr, int playerDice, Monster mob, int mobDice) {
        if(choiceCharArr[2].equals("방패병"))
        if (playerDice > mobDice) {
            System.out.println("선공입니다.");
            while (true) {

            }
        } else {
            System.out.println("후공입니다.");
            while (true) {

            }
        }
    }

//    public static void jobCheck(String inputJob){
//        if(inputJob.equals("검사")){
//            Swordsman ss = new Swordsman();
//            int choice = ss.jobSkillMenu();
//            switch (choice){
//                case 1:
//                    ss.skillAttack();
//                    break;
//
//                case 2:
//                    ss.skillMp();
//                    break;
//
//                case 3:
//                    ss.skillSpecial();
//                    break;
//
//                case 4:
//                    ss.skillRun();
//            }
//        } else if(inputJob.equals("방패병")){
//            Tanker tk = new Tanker();
//            int choice = tk.jobSkillMenu();
//            switch (choice){
//                case 1:
//                    tk.skillAttack();
//                    break;
//
//                case 2:
//                    tk.skillMp();
//                    break;
//
//                case 3:
//                    tk.skillSpecial();
//                    break;
//
//                case 4:
//                    tk.skillRun();
//            }
//        } else if(inputJob.equals("법사")){
//            Wizard wi = new Wizard();
//            int choice = wi.jobSkillMenu();
//            switch (choice){
//                case 1:
//                    wi.skillAttack();
//                    break;
//
//                case 2:
//                    wi.skillMp();
//                    break;
//
//                case 3:
//                    wi.skillSpecial();
//                    break;
//
//                case 4:
//                    wi.skillRun();
//            }
//        }
//    }
}

