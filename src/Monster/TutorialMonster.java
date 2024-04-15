package Monster;

public class TutorialMonster extends Monster{
    public TutorialMonster(){
        setMonsterName("튜토리얼용 잡몹");
        setHP(10);
        setMP(10);
        setCP(10);
        setNowHP(10);
        setGiveExp(10);
    }

    @Override
    public int monsterAttack(int[] getStatus) {
        System.out.printf("%s가 공격합니다.\n", getMonsterName());
        getStatus[1] -= (int)(getCP() * 0.1);
        return 0;
    }

    @Override
    public void monsterDie() {
        System.out.printf("%s이(가) 죽었습니다.", getMonsterName());
    }

    @Override
    public void monsterStat() {
        System.out.printf("현재 HP: %d\n", getNowHP());
    }
}
