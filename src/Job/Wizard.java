package Job;

import GamePlay.Dice;

public class Wizard extends Job{
//    public Wizard(){
//        setJobName("법사");
//        setHP(70);
//        setMP(125);
//        setCP(105);
//        setNowHP(70);
//        setNowMP(125);
//        setNowCP(105);
//        setExp(0);
//        setLevel(1);
//    }

    @Override
    public int skillAttack(int[] getStatus) {
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
            return (int)(getStatus[5] * 0.08);
        } else{
            System.out.println("지팡이 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillMp(int[] getStatus) {
        System.out.println("마법 공격 시도");

        if(getStatus[3] < 5){
            System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.");
            return 0;
        }

        getStatus[3] -= 5;

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
            System.out.println("마법 공격 성공");
            return (int)((getStatus[5] + getStatus[5] * 0.3) * 0.1);
        } else{
            System.out.println("마법 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillSpecial(int[] getStatus) {
        System.out.println("힐링 시도");

        if(getStatus[3] < 10){
            System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.");
            return 0;
        }

        getStatus[3] -= 10;

        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("주사위를 굴립니다.(5 이상 성공)");

        try {
            Thread.sleep(800);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        int rdInt = Dice.dice();
        System.out.println("주사위: " + rdInt);

        if (rdInt >= 5) {
            if(getStatus[0] > (int)(getStatus[1] + (getStatus[5] * 0.3))){
                getStatus[1] = (int)(getStatus[1] + (getStatus[5] * 0.3));
                System.out.println(getStatus[0]);
            } else {
                getStatus[1] = getStatus[0];
            }
            System.out.println("힐링 성공");
            return 1;
        } else {
            System.out.println("힐링 실패");
            return 0;
        }
    }

    @Override
    public int jobSkillMenu() {
        System.out.println("동작 선택");
        System.out.println("""
                1. 지팡이 휘두르기
                2. 마법 공격
                3. 힐링
                4. 도망치기""");
        int choiceSkill = sc.nextInt();

        return choiceSkill;
    }
}
