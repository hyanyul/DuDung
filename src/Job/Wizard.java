package Job;

import GamePlay.Dice;

public class Wizard extends Job{
    Wizard(){
        setJobName("법사");
        setHP(70);
        setMP(125);
        setCP(105);
        setNowHP(70);
        setNowMP(125);
        setNowCP(105);
    }

    @Override
    public double skillAttack() {
        System.out.println("지팡이 휘두르기 공격 시도");

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
            System.out.println("지팡이 휘두르기 공격 성공");
            return getCP() * 0.08;
        } else{
            System.out.println("지팡이 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public double skillMp() {
        System.out.println("마법 공격 시도");

        setMP(getMP() - 5);

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
            System.out.println("마법 공격 성공");
            return (getCP() + getCP() * 0.3) * 0.1;
        } else{
            System.out.println("마법 공격 실패");
            return 0;
        }
    }

    @Override
    public double skillSpecial() {
        System.out.println("힐링 시도");

        setMP(getMP() - 10);

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

        if (rdInt >= 4) {
            if(getHP() > getNowHP() + (getNowCP() * 0.3)){
                setNowHP(getNowHP() + (getNowCP() * 0.3));
                System.out.println(getNowHP());
            } else {
                setNowHP(getHP());
            }
            System.out.println("힐링 성공");
            return 1;
        } else {
            System.out.println("힐링 실패");
            return 0;
        }
    }
}
