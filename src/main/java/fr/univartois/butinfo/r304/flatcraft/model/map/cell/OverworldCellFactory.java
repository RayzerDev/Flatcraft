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
            return createResourceCell("junglegrass", ToolType.NO_TOOL,2);
        }

        if (RANDOM.nextInt(10) < 2) {
            return createCell("water");
        }

        return createResourceCell("grass", ToolType.NO_TOOL,5);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory#createSubSoil()
     */
    @Override
    public Cell createSubSoil() {
        if(RANDOM.nextInt(100)<1){
            return createResourceCell("mineral_gold", ToolType.NO_TOOL, "gold_lump",5);
        }
        return createResourceCell("dirt", ToolType.NO_TOOL,5);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory#createTrunk()
     */
    @Override
    public Cell createTrunk() {
        return createResourceCell("tree", ToolType.NO_TOOL,10);
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
    private Cell createResourceCell(String name, ToolType tool, int hardness) {
        Sprite sprite = spriteStore.getSprite(name);
        return new CellGrid(new Resource(name, sprite, tool, hardness, new OnMapState(sprite)));
    }
    private Cell createResourceCell(String name, ToolType tool, String nextName, int hardness) {
        Sprite sprite = spriteStore.getSprite(name);
        Sprite nextSprite = spriteStore.getSprite(nextName);
        return new CellGrid(new Resource(name, sprite, tool, hardness, new OnMapState(sprite, nextSprite)));
    }

    public static OverworldCellFactory getInstance() {
        return instance;
    }
}
