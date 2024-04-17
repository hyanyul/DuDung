package GamePlay;

import java.util.Random;

public class Function {
    
    // 주사위 기능
    public static int dice(){
        Random rd = new Random();
        
        // 1~10 숫자 중 랜덤으로 하나 나옴
        return rd.nextInt(10)  + 1;
    }

    // 원하는 시간만큼 콘솔창 정지(메인 스레드 정지)
    public static void timeSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // 배틀 중 스텟 확인
    public static void statusInfo(int[] getStatus){
        System.out.printf("""
                [현재 상황]
                HP: %d, MP: %d, CP: %d\n""", getStatus[1], getStatus[3], getStatus[5]);
    }

    // 게임 오버의 경우 스텟이 이전으로 돌아가야 함
    // 전투 직전 스텟 복사 용도
    public static int[] saveStatus(int[] getStatus){
        int[] saveStatus = new int[getStatus.length];

        for (int i=0; i< getStatus.length; i++){
            saveStatus[i] = getStatus[i];
        }

        return saveStatus;
    }
}
