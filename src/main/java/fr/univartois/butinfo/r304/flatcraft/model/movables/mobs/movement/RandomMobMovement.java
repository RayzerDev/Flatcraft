package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement;

import java.util.Random;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.AbstractMob;

public final class RandomMobMovement implements IMobMovementStrategy {
    private static final Random random = new Random();
    @Override
    public void move(AbstractMob mob) {
        mob.setHorizontalSpeed(random.nextDouble(-150,150));
    }
}
