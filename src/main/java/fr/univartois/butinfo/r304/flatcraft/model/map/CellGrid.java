package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class CellGrid extends AbstractCell{
    public CellGrid(int row, int column) {
        super(row, column);
    }

    public CellGrid(Sprite sprite) {
        super(sprite);
    }

    public CellGrid(Resource resource) {
        super(resource);
    }

    @Override
    public boolean move(IMovable movable) {
        if (getResource() == null) {
            double newX = getColumn() * getSprite().getWidth();
            double newY = getRow() * getSprite().getHeight();

            movable.setX((int) newX);
            movable.setY((int) newY);

            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean dig(IMovable player) {
        return false;
    }
}
