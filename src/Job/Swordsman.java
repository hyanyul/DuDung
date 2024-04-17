package Job;

import GamePlay.Function;

public class Swordsman extends Job{
    @Override
    public int skillAttack(int[] getStatus) {
        System.out.println("~검 휘두르기 공격 시도~\n");

        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(2 이상 성공)\n");

        Function.timeSleep(800);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 2) {
            System.out.println("\n검 휘두르기 공격 성공");
            return (int)(getStatus[5] * 0.1);
        } else{
            System.out.println("\n검 휘두르기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillMp(int[] getStatus) {
        System.out.println("~검기 쏘아보내기 공격 시도~\n");

        if(getStatus[3] < 5){
            System.out.println("마나가 부족하여 스킬을 사용할 수 없습니다.");
            return 0;
        }

        getStatus[3]  -= 5;

        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(3 이상 성공)\n");

        Function.timeSleep(800);
        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 3) {
            System.out.println("\n검기 쏘아보내기 공격 성공");
            return (int)((getStatus[5] + getStatus[5] * 0.2) * 0.1);
        } else{
            System.out.println("\n검기 쏘아보내기 공격 실패");
            return 0;
        }
    }

    @Override
    public int skillSpecial(int[] getStatus) {
        System.out.println("~급소 베기 공격 시도~\n");

        Function.timeSleep(300);

        System.out.println("주사위를 굴립니다.(4 이상 성공)\n");

        Function.timeSleep(800);

        int rdInt = Function.dice();
        System.out.println("주사위: " + rdInt);

        if(rdInt >= 4) {
            System.out.println("\n급소 베기 공격 성공");
            return (int)((getStatus[5] + getStatus[5] * 0.6) * 0.1);
        } else{
            System.out.println("\n급소 베기 공격 실패");
            return 0;
        }
    }

    @Override
    public int jobSkillMenu() {
        System.out.println("\n[동작 선택]");
        System.out.print("""
                1. 검 휘두르기
                2. 검기 쏘아보내기
                3. 급소 베기
                4. 도망치기\n>> """);
        int choiceSkill = sc.nextInt();
        sc.nextLine();

        return choiceSkill;
    }
}