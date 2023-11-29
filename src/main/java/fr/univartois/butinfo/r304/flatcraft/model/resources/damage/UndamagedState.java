package fr.univartois.butinfo.r304.flatcraft.model.resources.damage;

public class UndamagedState implements DamageState{
    private int hardness;

    public UndamagedState(int hardness){
        this.hardness = hardness;
    }
    @Override
    public int getHardness() {
        return hardness;
    }

    @Override
    public DamageState nextState() {
        if(hardness==1){
            return new DestroyedState();
        }
        hardness--;
        return new DamagedState(hardness);
    }

    @Override
    public boolean isDestroy() {
        return false;
    }
}
