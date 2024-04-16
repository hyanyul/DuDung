package Job;

import GamePlay.Function;

public class Wizard extends Job{
    @Override
    public int skillAttack(int[] getStatus) {
        System.out.println("~지팡이 휘두르기 공격 시도~\n");

//        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(2 이상 성공)\n");

//        Function.timeSleep(800);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 2) {
            System.out.println("\n지팡이 휘두르기 공격 성공");
            return (int)(getStatus[5] * 0.08);
        } else{
            System.out.println("\n지팡이 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillMp(int[] getStatus) {
        System.out.println("~마법 공격 시도~");

        if(getStatus[3] < 5){
            System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.");
            return 0;
        }

        getStatus[3] -= 5;

//        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(3 이상 성공)\n");

//        Function.timeSleep(800);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 3) {
            System.out.println("\n마법 공격 성공");
            return (int)((getStatus[5] + getStatus[5] * 0.3) * 0.1);
        } else{
            System.out.println("\n마법 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillSpecial(int[] getStatus) {
        System.out.println("~힐링 시도~\n");

        if(getStatus[3] < 10){
            System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.\n");
            return 0;
        }

        getStatus[3] -= 10;

        Function.timeSleep(1000);

        System.out.println("주사위를 굴립니다.(5 이상 성공)\n");

        Function.timeSleep(1000);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if (rdInt >= 5) {
            if(getStatus[0] > (int)(getStatus[1] + (getStatus[5] * 0.3))){
                getStatus[1] = (int)(getStatus[1] + (getStatus[5] * 0.3));
            } else {
                getStatus[1] = getStatus[0];
            }
            System.out.println("힐링 성공");
            System.out.printf("HP가 회복되어 %d이(가) 되었습니다.\n", getStatus[1]);
            return 1;
        } else {
            System.out.println("힐링 실패\n");
            return 0;
        }
    }

    @Override
    public int jobSkillMenu() {
        System.out.println("\n[동작 선택]");
        System.out.print("""
                1. 지팡이 휘두르기
                2. 마법 공격
                3. 힐링
                4. 도망치기\n>> """);
        int choiceSkill = sc.nextInt();
        sc.nextLine();

        return choiceSkill;
    }
}