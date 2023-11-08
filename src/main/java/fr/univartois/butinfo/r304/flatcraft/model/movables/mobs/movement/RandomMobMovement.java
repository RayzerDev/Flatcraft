package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement;

import java.util.Random;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.AbstractMob;

public final class RandomMobMovement implements IMobMovementStrategy {
    private static final Random random = new Random();
    @Override
    public void move(AbstractMob mob) {
        if(mob.getHorizontalSpeed()>=0) {
            mob.setHorizontalSpeed(random.nextDouble(80));
        }
        else {
            mob.setHorizontalSpeed(random.nextDouble(-80,0));
        }
        if(random.nextInt(100)>98){
            mob.setHorizontalSpeed(mob.getHorizontalSpeed()*-1);
        }
    }
}
