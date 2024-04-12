package Monster;

public class Monster {
    private String monsterName;
    private double nowHP;
    private double HP;
    private double nowMP;
    private double MP;
    private double nowCP;
    private double CP;
    private int giveExp;


    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
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

    public int getGiveExp() {
        return giveExp;
    }

    public void setGiveExp(int giveExp) {
        this.giveExp = giveExp;
    }

    public double monsterAttack(){
        System.out.println("몬스터 공격");
        return 0;
    }
    
    public void monsterDie(){
        System.out.println("몬스터 퇴치 완료");
    }
}
