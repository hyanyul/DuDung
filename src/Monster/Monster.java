package Monster;

// 모든 몬스터 부모 클래스
public class Monster {
    private String monsterName;
    private int nowHP;
    private int HP;
    private int MP;
    private int CP;
    private int giveExp;


    public String getMonsterName() {
        return monsterName;
    }

    public void setMonsterName(String monsterName) {
        this.monsterName = monsterName;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getMP() {
        return MP;
    }

    public void setMP(int MP) {
        this.MP = MP;
    }

    public int getCP() {
        return CP;
    }

    public void setCP(int CP) {
        this.CP = CP;
    }

    public int getNowHP() {
        return nowHP;
    }

    public void setNowHP(int nowHP) {
        this.nowHP = nowHP;
    }

    public int getGiveExp() {
        return giveExp;
    }

    public void setGiveExp(int giveExp) {
        this.giveExp = giveExp;
    }

    public int monsterAttack(int[] getStatus){
        System.out.println("몬스터 공격");
        return 0;
    }
    
    public void monsterDie(int[] getStatus){
        System.out.println("몬스터 퇴치 완료");
    }

    public void monsterStat(){
        System.out.println("몬스터 스텟");
    }
}