package fr.univartois.butinfo.r304.flatcraft.model.movables.mobs;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.movables.AbstractMovable;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class PassiveMob extends AbstractMovable {
    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public PassiveMob(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
    }
}
