package Job;

import GamePlay.Dice;

public class Swordsman extends Job{
    Swordsman(){
        setJobName("검사");
        setHP(100);
        setMP(80);
        setCP(120);
        setNowHP(100);
        setNowMP(80);
        setNowCP(120);
    }

    @Override
    public double skillAttack() {
        System.out.println("검 휘두르기 공격 시도");

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
            System.out.println("검 휘두르기 공격 성공");
            return getNowCP() * 0.1;
        } else{
            System.out.println("검 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public double skillMp() {
        System.out.println("검기 쏘아보내기 공격 시도");

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
            System.out.println("검기 쏘아보내기 공격 성공");
            return (getNowCP() + getNowCP() * 0.2) * 0.1;
        } else{
            System.out.println("검기 쏘아보내기 공격 실패");
            return 0;
        }
    }

    @Override
    public double skillSpecial() {
        System.out.println("급소 베기 공격 시도");

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("주사위를 굴립니다.(4 이상 성공)");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int rdInt = Dice.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 4) {
            System.out.println("급소 베기 공격 성공");
            return (getNowCP() + getNowCP() * 0.6) * 0.1;
        } else{
            System.out.println("급소 베기 공격 실패");
            return 0;
        }
    }
}
