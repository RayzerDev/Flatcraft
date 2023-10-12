package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;
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
        }
        return false;
    }

    @Override
    public boolean dig(Player player) {
        Resource resource = getResource();
        if (resource != null) {
            resource.dig();
            if (resource.getHardness() == 0) {
                player.addInventory(resource);
                getResourceProperty().set(null);
                return true;
            }
        }
        return false;
    }

}
