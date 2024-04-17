package GamePlay;

import Job.*;
import Monster.*;

public class Scenario {
    // String[] getChar = {0.닉네임, 1.종족, 2.직업}
    // int[] getStatus = {0.최대 체력, 1.현재 체력, 2.기본 마나, 3.현재 마나, 4.기본 공격력, 5.현재 공격력, 6.경험치, 7.레벨, 8.진행도}
    
    // 게임 로고
    public void start() {
        System.out.println("""
                ██████╗ ██╗   ██╗██████╗ ██╗   ██╗███╗   ██╗ ██████╗\s
                ██╔══██╗██║   ██║██╔══██╗██║   ██║████╗  ██║██╔════╝\s
                ██║  ██║██║   ██║██║  ██║██║   ██║██╔██╗ ██║██║  ███╗
                ██║  ██║██║   ██║██║  ██║██║   ██║██║╚██╗██║██║   ██║
                ██████╔╝╚██████╔╝██████╔╝╚██████╔╝██║ ╚████║╚██████╔╝
                ╚═════╝  ╚═════╝ ╚═════╝  ╚═════╝ ╚═╝  ╚═══╝ ╚═════╝\s
                """);
    }

    // 튜토리얼 스토리
    public int[] tutorial(String[] getChar, int[] getStatus, Monster m) {
        System.out.println("당신은 모험을 떠나게 되었습니다.\n\n");

        Function.timeSleep(2000);

        System.out.println("네? 너무 갑작스럽다구요? 앞뒤 설명은 없냐구요?\n");

        Function.timeSleep(1000);

        System.out.println("어쩔 수 없습니다. 이미 모험은 시작되었고, 당신이 이 모험을 끝내기 위해서는 보스를 쓰러뜨려야만 합니다.\n\n");

        Function.timeSleep(1000);

        System.out.println("마침 튜토리얼용으로 딱 좋은 몬스터가 나타났네요.\n\n바로 전투해볼까요?\n\n");

        int[] saveStatus = Function.saveStatus(getStatus);
        
        // 변경된 스텟이 db에 반영이 안되는 문제 -> return 이용해서 변경된 스텟을 불러옴
        getStatus = Tutorial.tutoBattle(getChar, getStatus, m, saveStatus);

        return getStatus;

    }
}