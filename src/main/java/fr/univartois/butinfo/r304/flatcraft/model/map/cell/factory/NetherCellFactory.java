package fr.univartois.butinfo.r304.flatcraft.model.map.cell.factory;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellGrid;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.ToolType;
import fr.univartois.butinfo.r304.flatcraft.model.resources.location.OnMapState;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

import java.util.Random;

public class NetherCellFactory implements CellFactory {

    public static final String DESERT_STONE = "desert_stone";
    private final Random random = new Random();
    ISpriteStore spriteStore;

    private static final NetherCellFactory instance = new NetherCellFactory();

    private NetherCellFactory(){}

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
        if (random.nextInt(10) < 4) {
            return createResourceCell(DESERT_STONE);
        }
        return createCell("lava");
    }

    @Override
    public Cell createSubSoil() {
        return createResourceCell(DESERT_STONE);
    }

    @Override
    public Cell createFirstSubSoil() {
        return createResourceCell(DESERT_STONE);
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

    private Cell createResourceCell(String name) {
        Sprite sprite = spriteStore.getSprite(name);
        return new CellGrid(new Resource(name, ToolType.NO_TOOL, 1, new OnMapState(sprite)));
    }
    private Cell createResourceCell(String name, String nextName) {
        Sprite sprite = spriteStore.getSprite(name);
        Sprite nextSprite = spriteStore.getSprite(nextName);
        return new CellGrid(new Resource(name, ToolType.NO_TOOL, 1, new OnMapState(sprite, nextSprite)));
    }

    public static NetherCellFactory getInstance() {
        return instance;
    }
}
