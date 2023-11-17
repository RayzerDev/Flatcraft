package fr.univartois.butinfo.r304.flatcraft.model.map.cell;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.IMovable;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class CellGrid extends AbstractCell {
    private CellState state;
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
            movable.setX(getColumn() * getSprite().getWidth());
            movable.setY(getRow() * getSprite().getHeight());
            return true;
        }
        return false;
    }

    public void setState(Cell cell){
        if(cell.getResource()==null){
            state = new CellNoResources();
        }
        else {
            state = new CellResources();
        }
    }


    public void handleResources(Player player){
        state.handleResources(player, this);
    }

    @Override
    public boolean dig(Player player) {
        Resource resource = getResource();
        if (resource != null) {
            resource.dig();
            if (resource.getHardness() == 0) {
                player.addInventory(resource);
                return true;
            }
        }
        return false;
    }

    @Override
    public void replaceBy(Cell cell) {
        if(getResource().getHardness()==0){
            super.replaceBy(cell);
        }
    }
}
