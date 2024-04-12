package Monster;

public class TutorialMonster extends Monster{
    public TutorialMonster(){
        setMonsterName("튜토리얼용 잡몹");
        setHP(10);
        setMP(10);
        setCP(10);
        setNowHP(10);
        setNowMP(10);
        setNowCP(10);
        setGiveExp(10);
    }

    @Override
    public double monsterAttack() {
        System.out.printf("%s가 공격합니다.\n", getMonsterName());

        return getNowCP() * 0.1;
    }

    @Override
    public void monsterDie() {
        System.out.printf("%s이(가) 죽었습니다.", getMonsterName());
    }
}
