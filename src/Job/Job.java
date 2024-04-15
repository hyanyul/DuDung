package Job;
import GamePlay.Dice;

import java.util.Scanner;

public class Job {
    Scanner sc = new Scanner(System.in);

    public int skillAttack(int[] getStatus){
        System.out.println("기본 물리 공격");
        return 0;
    }       // 기본 물리 공격(무기 휘두르기)

    public int skillMp(int[] getStatus){
        System.out.println("마나 공격");
        return 0;
    }           // 마나 사용 스킬

    public int skillRun(){
        System.out.println("도망치기 시도");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("주사위를 굴립니다.(3 이상 성공)");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int rdInt = Dice.dice();
        System.out.println("주사위: " + rdInt);

        if (rdInt >= 3){
            System.out.println("도망쳤습니다.");
            return -1;
        } else {
            System.out.println("도망치지 못했습니다.");
            return 0;
        }
    }
    
    public int skillSpecial(int[] getStatus){
        System.out.println("직업 특수 스킬");
        return 0;
    }

    public int jobSkillMenu(){
        return 0;
    }

    public void levelPlus(int[] getStatus){
        System.out.printf("현재 경험치: %d", getStatus[6]);
        if(getStatus[6] >= 20 && getStatus[6] < 50){
            getStatus[7] = 2;
            System.out.println("레벨 업! 2레벨이 되었습니다.");
        } else if(getStatus[6] >= 50 && getStatus[6] < 90){
            getStatus[7] = 3;
            System.out.println("레벨 업! 3레벨이 되었습니다.");
        } else if(getStatus[6] >= 90 && getStatus[6] < 140){
            getStatus[7] = 4;
            System.out.println("레벨 업! 4레벨이 되었습니다.");
        } else if(getStatus[6] >= 140 && getStatus[6] < 200){
            getStatus[7] = 5;
            System.out.println("레벨 업! 5레벨이 되었습니다.");
        } else if(getStatus[6] >= 200 && getStatus[6] < 270){
            getStatus[7] = 6;
            System.out.println("레벨 업! 6레벨이 되었습니다.");
        } else if(getStatus[6] >= 270 && getStatus[6] < 350){
            getStatus[7] = 7;
            System.out.println("레벨 업! 7레벨이 되었습니다.");
        } else if(getStatus[6] >= 350 && getStatus[6] < 540){
            getStatus[7] = 8;
            System.out.println("레벨 업! 8레벨이 되었습니다.");
        } else if(getStatus[6] >= 540 && getStatus[6] < 640){
            getStatus[7] = 9;
            System.out.println("레벨 업! 9레벨이 되었습니다.");
        } else if(getStatus[6] >= 640 && getStatus[6] < 750){
            getStatus[7] = 10;
            System.out.println("레벨 업! 10레벨이 되었습니다.");
        }
    }

    public void statusInfo(int[] getStatus){
        System.out.printf("""
                [현재 상황]
                HP: %d, MP: %d, CP: %d\n""", getStatus[1], getStatus[3], getStatus[5]);
    }
}