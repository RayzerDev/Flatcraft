package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement;

import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.AbstractMob;

public final class LinearMobMovement implements IMobMovementStrategy {

    @Override
    public void move(AbstractMob mob) {
        mob.setHorizontalSpeed(150);
    }
}
