package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.ToolType;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

import java.util.Random;

public class OverworldCellFactory implements CellFactory {
    private Random RANDOM = new Random();

    ISpriteStore spriteStore;
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.CellFactory#createSky()
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
     * @see fr.univartois.butinfo.r304.flatcraft.model.CellFactory#createSoilSurface()
     */
    @Override
    public Cell createSoilSurface() {
        if (RANDOM.nextInt(10) < 1) {
            return createResourceCell("junglegrass");
        }

        if (RANDOM.nextInt(10) < 2) {
            return createResourceCell("water");
        }

        return createResourceCell("grass");
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.CellFactory#createSubSoil()
     */
    @Override
    public Cell createSubSoil() {
        return createResourceCell("dirt");
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.CellFactory#createTrunk()
     */
    @Override
    public Cell createTrunk() {
        return createCell("tree");
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.CellFactory#createLeaves()
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
    private Cell createResourceCell(String name) {
        Sprite sprite = spriteStore.getSprite(name);
        return new CellGrid(new Resource(name, sprite, ToolType.NO_TOOL, 1));
    }

}
