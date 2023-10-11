package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.ToolType;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import java.util.Random;

public class CellGridFactory implements CellFactory {
    private Random RANDOM = new Random();

    ISpriteStore spriteStore;
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    @Override
    public Cell createSky() {
        if (RANDOM.nextInt(100)<20){
            return new CellGrid(this.spriteStore.getSprite("cloud"));
        }
        return new CellGrid(this.spriteStore.getSprite("ice"));
    }

    @Override
    public Cell createSoilSurface() {
        return new CellGrid(new Resource("grass",this.spriteStore.getSprite("grass"), ToolType.NO_TOOL,1));
    }

    @Override
    public Cell createSubSoil() {
        return new CellGrid(new Resource("dirt",this.spriteStore.getSprite("dirt"), ToolType.NO_TOOL,1));
    }

    @Override
    public Cell createTrunk() {
        return null;
    }

    @Override
    public Cell createLeaves() {
        return null;
    }
}
