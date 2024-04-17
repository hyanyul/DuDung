package Monster;

public class TutorialMonster extends Monster{
    // 몬스터 스텟 셋팅
    public TutorialMonster(){
        setMonsterName("튜토리얼용 잡몹");
        setHP(10);
        setMP(10);
        setCP(10);
        setNowHP(10);
        setGiveExp(10);
    }

    // 몬스터 공격
    @Override
    public int monsterAttack(int[] getStatus) {
        System.out.printf("%s이(가) 공격합니다.\n", getMonsterName());
        getStatus[1] -= (int)(getCP() * 0.1);
        return 0;
    }

    // 몬스터 죽음
    @Override
    public void monsterDie(int[] getStatus) {
        System.out.printf("%s이(가) 죽었습니다.\n\n", getMonsterName());
        getStatus[6] += getGiveExp();
    }
    
    // 몬스터 체력 출력
    @Override
    public void monsterStat() {
        System.out.printf("현재 %s의 HP: %d\n\n", getMonsterName(), getNowHP());
    }
}
