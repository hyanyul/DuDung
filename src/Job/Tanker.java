package Job;

import GamePlay.Dice;

public class Tanker extends Job {
    Tanker(){
        setJobName("방패병");
        setHP(140);
        setMP(90);
        setCP(70);
        setNowHP(140);
        setNowMP(90);
        setNowCP(70);
    }

    @Override
    public double skillAttack() {

        System.out.println("방패 휘두르기 공격 시도");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("주사위를 굴립니다.(2 이상 성공)");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int rdInt = Dice.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 2) {
            System.out.println("방패 휘두르기 공격 성공");
            return getNowCP() * 0.1;
        } else{
            System.out.println("방패 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public double skillMp() {
        System.out.println("공격력 올리기 시도");

        setNowMP(getNowMP() - 5);

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("주사위를 굴립니다.(2 이상 성공)");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int rdInt = Dice.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 2) {
            setCP(getNowCP() + 5);
            System.out.println("공격력 올리기 성공");
            return 1;
        } else{
            System.out.println("공격력 올리기 실패");
            return 0;
        }
    }

    @Override
    public double skillSpecial() {
        System.out.println("방어 시도");

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

        if(rdInt >= 3) {
            System.out.println("방어 성공");
            return 1;
        } else{
            System.out.println("방어 실패");
            return 0;
        }
    }
}
