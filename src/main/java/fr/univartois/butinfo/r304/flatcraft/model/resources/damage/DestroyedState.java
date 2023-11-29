package fr.univartois.butinfo.r304.flatcraft.model.resources.damage;

public class DestroyedState implements DamageState {
    @Override
    public int getHardness() {
        return 0;
    }

    @Override
    public DamageState nextState() {
        return this;
    }

    @Override
    public boolean isDestroy() {
        return true;
    }
}
