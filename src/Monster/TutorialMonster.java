package Monster;

public class TutorialMonster extends Monster{
    public TutorialMonster(){
        setMonsterName("튜토리얼용 잡몹");
        setHP(10);
        setMP(10);
        setCP(1000);
        setNowHP(10);
        setGiveExp(10);
    }

    @Override
    public int monsterAttack(int[] getStatus) {
        System.out.printf("%s이(가) 공격합니다.\n", getMonsterName());
        getStatus[1] -= (int)(getCP() * 0.1);
        return 0;
    }

    @Override
    public void monsterDie(int[] getStatus) {
        System.out.printf("%s이(가) 죽었습니다.\n\n", getMonsterName());
        getStatus[6] += getGiveExp();
    }

    @Override
    public void monsterStat() {
        System.out.printf("현재 %s의 HP: %d\n\n", getMonsterName(), getNowHP());
    }
}
