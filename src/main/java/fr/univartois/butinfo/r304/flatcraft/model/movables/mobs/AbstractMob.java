package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.flatcraft.model.movables.mobs.movement.IMobMovementStrategy;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public abstract class AbstractMob extends AbstractMovable {
    private IMobMovementStrategy movementStrategy;
    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    protected AbstractMob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite, IMobMovementStrategy movement) {
        super(game, xPosition, yPosition, sprite);
        this.movementStrategy = movement;
    }
    @Override
    public boolean move(long delta){
        movementStrategy.move(this);
        return super.move(delta);
    }
}
