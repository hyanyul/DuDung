package Job;
import GamePlay.Dice;

import java.util.Scanner;

public class Job {
    Scanner sc = new Scanner(System.in);
    private String jobName;     // 직업명
    private double nowHP;      // 현재 체력
    private double HP;         // 체력
    private double nowMP;      // 현재 마나
    private double MP;         // 마나
    private double nowCP;      // 현재 공격력
    private double CP;         // 공격력
    private int exp;            // 경험치
    private int level;          // 레벨


    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public double getHP() {
        return HP;
    }

    public void setHP(double HP) {
        this.HP = HP;
    }

    public double getMP() {
        return MP;
    }

    public void setMP(double MP) {
        this.MP = MP;
    }

    public double getCP() {
        return CP;
    }

    public void setCP(double CP) {
        this.CP = CP;
    }

    public double getNowHP() {
        return nowHP;
    }

    public void setNowHP(double nowHP) {
        this.nowHP = nowHP;
    }

    public double getNowMP() {
        return nowMP;
    }

    public void setNowMP(double nowMP) {
        this.nowMP = nowMP;
    }

    public double getNowCP() {
        return nowCP;
    }

    public void setNowCP(double nowCP) {
        this.nowCP = nowCP;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double skillAttack(){
        System.out.println("기본 물리 공격");
        return 0;
    }       // 기본 물리 공격(무기 휘두르기)

    public double skillMp(){
        System.out.println("마나 공격");
        return 0;
    }           // 마나 사용 스킬

    public int skillRun(){
        System.out.println("도망치기 시도");

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

        if (rdInt >= 3){
            System.out.println("도망쳤습니다.");
            return 1;
        } else {
            System.out.println("도망치지 못했습니다.");
            return 0;
        }
    }
    
    public double skillSpecial(){
        System.out.println("직업 특수 스킬");
        return 0;
    }

    public int jobSkillMenu(){
        return 0;
    }

    public void levelPlus(int exp){
        if(exp >= 20 && exp < 50){
            setLevel(2);
        } else if(exp >= 50 && exp < 90){
            setLevel(3);
        } else if(exp >= 90 && exp < 140){
            setLevel(4);
        } else if(exp >= 140 && exp < 200){
            setLevel(5);
        } else if(exp >= 200 && exp < 270){
            setLevel(6);
        } else if(exp >= 270 && exp < 350){
            setLevel(7);
        } else if(exp >= 350 && exp < 540){
            setLevel(8);
        } else if(exp >= 540 && exp < 640){
            setLevel(9);
        } else if(exp >= 640 && exp < 750){
            setLevel(10);
        }
    }
}
