package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.AbstractMob;

import java.util.Random;

public class IntelligentMobMovement implements IMobMovementStrategy{
    private static final Random random = new Random();

    private final Player player;

    public IntelligentMobMovement(Player player) {
        this.player = player;
    }

    @Override
    public void move(AbstractMob mob) {
        int distancePlayer = Math.abs(player.getX()-mob.getX());
        if(distancePlayer > 10) {
            if (distancePlayer <= 110) {
                if (player.getX() > mob.getX()) {
                    mob.setHorizontalSpeed(80);
                }
                else{
                    mob.setHorizontalSpeed(-80);
                }
            }
            else {
                if(mob.getHorizontalSpeed()>=0) {
                    mob.setHorizontalSpeed(random.nextDouble(80));
                }
                else {
                    mob.setHorizontalSpeed(random.nextDouble(-80,0));
                }
                if(random.nextInt(1000)>998){
                    mob.setHorizontalSpeed(mob.getHorizontalSpeed()*-1);
                }
            }
        }
    }
}
