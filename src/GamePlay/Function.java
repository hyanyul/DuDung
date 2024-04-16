package GamePlay;

import java.util.Random;

public class Function {
    public static int dice(){
        Random rd = new Random();
        return rd.nextInt(10)  + 1;
    }

    public static void timeSleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void statusInfo(int[] getStatus){
        System.out.printf("""
                [현재 상황]
                HP: %d, MP: %d, CP: %d\n""", getStatus[1], getStatus[3], getStatus[5]);
    }

    public static int[] saveStatus(int[] getStatus){
        int[] saveStatus = new int[getStatus.length];

        for (int i=0; i< getStatus.length; i++){
            saveStatus[i] = getStatus[i];
        }

        return saveStatus;
    }
}
