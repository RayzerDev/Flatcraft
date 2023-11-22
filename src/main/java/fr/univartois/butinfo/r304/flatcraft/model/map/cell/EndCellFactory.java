package fr.univartois.butinfo.r304.flatcraft.model.map.cell;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.ToolType;
import fr.univartois.butinfo.r304.flatcraft.model.resources.state.OnMapState;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;


public class EndCellFactory implements CellFactory {
    ISpriteStore spriteStore;

    private static EndCellFactory instance = new EndCellFactory();

    private EndCellFactory(){}

    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }

    @Override
    public Cell createSky() {
        return createCell("coal_block");
    }

    @Override
    public Cell createSoilSurface() {
        return createResourceCell("sandstone", ToolType.NO_TOOL);
    }

    @Override
    public Cell createSubSoil() {
        return createResourceCell("sandstone", ToolType.NO_TOOL);
    }

    @Override
    public Cell createTrunk() {
        return createCell("tree");
    }

    @Override
    public Cell createLeaves() {
        return createCell("leaves");
    }

    private Cell createCell(String name) {
        Sprite sprite = spriteStore.getSprite(name);
        return new CellGrid(sprite);
    }

    private Cell createResourceCell(String name, ToolType tool) {
        Sprite sprite = spriteStore.getSprite(name);
        return new CellGrid(new Resource(name, sprite, tool, 1, new OnMapState(sprite)));
    }
    private Cell createResourceCell(String name, ToolType tool, String nextName) {
        Sprite sprite = spriteStore.getSprite(name);
        Sprite nextSprite = spriteStore.getSprite(nextName);
        return new CellGrid(new Resource(name, sprite, tool, 1, new OnMapState(sprite, nextSprite)));
    }

    public static EndCellFactory getInstance() {
        return instance;
    }
}
