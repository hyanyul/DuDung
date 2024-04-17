package Job;

import GamePlay.Function;

public class Tanker extends Job {
    @Override
    public int skillAttack(int[] getStatus) {

        System.out.println("~방패 휘두르기 공격 시도~\n");

        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(2 이상 성공)\n");

        Function.timeSleep(800);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 2) {
            System.out.println("\n방패 휘두르기 공격 성공");
            return (int)(getStatus[5] * 0.1);
        } else{
            System.out.println("\n방패 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillMp(int[] getStatus) {
        System.out.println("~공격력 올리기 시도~\n");

        if(getStatus[3] < 5){
            System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.\n");
            return 0;
        }

        getStatus[3] -= 5;

        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(3 이상 성공)\n");

        Function.timeSleep(800);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 3) {
            getStatus[5] += 5;
            System.out.println("\n공격력 올리기 성공");
            return 1;
        } else{
            System.out.println("\n공격력 올리기 실패");
            return 0;
        }
    }

    @Override
    public int skillSpecial(int[] getStatus) {
        System.out.println("~방어 시도~\n");

        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(3 이상 성공)\n");

        Function.timeSleep(800);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 3) {
            System.out.println("\n방어 성공");
            return 1;
        } else{
            System.out.println("\n방어 실패");
            return 0;
        }
    }
    
    @Override
    public int jobSkillMenu() {
        System.out.println("\n[동작 선택]");
        System.out.print("""
                1. 방패 휘두르기
                2. 공격력 올리기
                3. 방어
                4. 도망치기\n>> """);
        int choiceSkill = sc.nextInt();
        sc.nextLine();

        return choiceSkill;
    }
}
