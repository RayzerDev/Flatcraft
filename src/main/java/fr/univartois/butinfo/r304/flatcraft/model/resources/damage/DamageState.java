package fr.univartois.butinfo.r304.flatcraft.model.resources.damage;

public interface DamageState {
    int getHardness();
    DamageState nextState();

    boolean isDestroy();
}
