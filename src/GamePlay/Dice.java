package GamePlay;

import java.util.Random;

public class Dice {
    public static int dice(){
        Random rd = new Random();
        return rd.nextInt(6)  + 1;
    }
}
