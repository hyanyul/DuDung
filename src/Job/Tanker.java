package Job;

import GamePlay.Dice;

public class Tanker extends Job {
//    public Tanker(){
//        setJobName("방패병");
//        setHP(140);
//        setMP(90);
//        setCP(70);
//        setNowHP(140);
//        setNowMP(90);
//        setNowCP(70);
//        setExp(0);
//        setLevel(1);
//    }

    @Override
    public int skillAttack(int[] getStatus) {

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
            return (int)(getStatus[5] * 0.1);
        } else{
            System.out.println("방패 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillMp(int[] getStatus) {
        System.out.println("공격력 올리기 시도");

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
            getStatus[5] += 5;
            System.out.println("공격력 올리기 성공");
            return 1;
        } else{
            System.out.println("공격력 올리기 실패");
            return 0;
        }
    }

    @Override
    public int skillSpecial(int[] getStatus) {
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
    
    @Override
    public int jobSkillMenu() {
        System.out.println("동작 선택");
        System.out.println("""
                1. 방패 휘두르기
                2. 공격력 올리기
                3. 방어
                4. 도망치기""");
        int choiceSkill = sc.nextInt();

        return choiceSkill;
    }
}
