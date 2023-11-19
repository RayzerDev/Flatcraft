package fr.univartois.butinfo.r304.flatcraft.model.map.cell;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.ToolType;
import fr.univartois.butinfo.r304.flatcraft.model.resources.state.OnMapState;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

import java.util.Random;

public class OverworldCellFactory implements CellFactory {
    private Random RANDOM = new Random();

    ISpriteStore spriteStore;

    private static OverworldCellFactory instance = new OverworldCellFactory();

    private OverworldCellFactory(){};
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory#createSky()
     */
    @Override
    public Cell createSky() {
        if (RANDOM.nextInt(10) < 1) {
            return createCell("cloud");
        }
        return createCell("ice");
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory#createSoilSurface()
     */
    @Override
    public Cell createSoilSurface() {
        if (RANDOM.nextInt(10) < 1) {
            return createResourceCell("junglegrass", ToolType.NO_TOOL);
        }

        if (RANDOM.nextInt(10) < 2) {
            return createCell("water");
        }

        return createResourceCell("grass", ToolType.NO_TOOL);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory#createSubSoil()
     */
    @Override
    public Cell createSubSoil() {
        return createResourceCell("dirt", ToolType.NO_TOOL);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory#createTrunk()
     */
    @Override
    public Cell createTrunk() {
        return createResourceCell("tree", ToolType.NO_TOOL);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory#createLeaves()
     */
    @Override
    public Cell createLeaves() {
        return createCell("leaves");
    }


    /**
     * Crée une cellule affichant le sprite ayant le nom donné.
     *
     * @param name Le nom du sprite de la cellule à créer.
     *
     * @return La cellule créée.
     */
    private Cell createCell(String name) {
        Sprite sprite = spriteStore.getSprite(name);
        return new CellGrid(sprite);
    }

    /**
     * Crée une cellule contenant la ressource ayant le nom donné.
     *
     * @param name Le nom du sprite de la ressource contenue dans la cellule à créer.
     *
     * @return La cellule créée.
     */
    private Cell createResourceCell(String name, ToolType tool) {
        Sprite sprite = spriteStore.getSprite(name);
        return new CellGrid(new Resource(name, tool, 1, new OnMapState(sprite)));
    }
    private Cell createResourceCell(String name, ToolType tool, String nextName) {
        Sprite sprite = spriteStore.getSprite(name);
        Sprite nextSprite = spriteStore.getSprite(nextName);
        return new CellGrid(new Resource(name, tool, 1, new OnMapState(sprite, nextSprite)));
    }

    public static OverworldCellFactory getInstance() {
        return instance;
    }
}
