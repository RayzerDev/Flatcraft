package fr.univartois.butinfo.r304.flatcraft.model.resources.damage;

public class DamagedState implements DamageState{
    private int hardness;
    public DamagedState(int hardness) {
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
        return this;
    }
    @Override
    public boolean isDestroy() {
        return false;
    }
}
