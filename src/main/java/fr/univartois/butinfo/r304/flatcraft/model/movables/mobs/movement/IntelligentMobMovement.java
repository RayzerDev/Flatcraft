package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.AbstractMob;

import java.util.Random;

public class IntelligentMobMovement implements IMobMovementStrategy{
    private static final Random random = new Random();

    private Player player;

    public IntelligentMobMovement(Player player) {
        this.player = player;
    }

    @Override
    public void move(AbstractMob mob) {
        int distancePlayer = Math.abs(player.getWidth()-mob.getWidth());
        if(distancePlayer > 3) {
            if (distancePlayer <= 20) {
                if (player.getWidth() > mob.getWidth()) {
                    mob.setHorizontalSpeed(100);
                }
                else{
                    mob.setHorizontalSpeed(-100);
                }
            }
            else {
                mob.setHorizontalSpeed(random.nextDouble(-100,100));
            }
        }
    }
}
