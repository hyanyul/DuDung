package Job;

import GamePlay.Dice;

public class Swordsman extends Job{

    @Override
    public int skillAttack(int[] getStatus) {
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
            return (int)(getStatus[5] * 0.1);
        } else{
            System.out.println("검 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillMp(int[] getStatus) {
        System.out.println("검기 쏘아보내기 공격 시도");

        if(getStatus[3] < 5){
            System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.");
            return 0;
        }

        getStatus[3]  -= 5;

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
            System.out.println("검기 쏘아보내기 공격 성공");
            return (int)((getStatus[5] + getStatus[5] * 0.2) * 0.1);
        } else{
            System.out.println("검기 쏘아보내기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillSpecial(int[] getStatus) {
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
            return (int)((getStatus[5] + getStatus[5] * 0.6) * 0.1);
        } else{
            System.out.println("급소 베기 공격 실패");
            return 0;
        }
    }

    @Override
    public int jobSkillMenu() {
        System.out.println("동작 선택");
        System.out.println("""
                1. 검 휘두르기
                2. 검기 쏘아보내기
                3. 급소 베기
                4. 도망치기""");
        int choiceSkill = sc.nextInt();

        return choiceSkill;
    }
}