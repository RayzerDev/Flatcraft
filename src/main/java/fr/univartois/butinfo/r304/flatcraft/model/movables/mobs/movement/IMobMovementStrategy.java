package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement;

import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.AbstractMob;

public interface IMobMovementStrategy {
    void move(AbstractMob mob);
}