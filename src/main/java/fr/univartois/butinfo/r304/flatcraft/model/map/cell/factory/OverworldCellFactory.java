package fr.univartois.butinfo.r304.flatcraft.model.map.cell.factory;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellGrid;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.model.resources.ToolType;
import fr.univartois.butinfo.r304.flatcraft.model.resources.location.OnMapState;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

import java.util.Random;

public class OverworldCellFactory implements CellFactory {
    public static final String STONE = "stone";
    private final Random random = new Random();

    ISpriteStore spriteStore;

    private static final OverworldCellFactory instance = new OverworldCellFactory();

    private OverworldCellFactory(){}
    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {
        this.spriteStore = spriteStore;
    }


    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.factories.CellFactory#createSky()
     */
    @Override
    public Cell createSky() {
        if (random.nextInt(10) < 1) {
            return createCell("cloud");
        }
        return createCell("ice");
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.factories.CellFactory#createSoilSurface()
     */
    @Override
    public Cell createSoilSurface() {
        if (random.nextInt(100) < 2) {
            return createResourceCell("junglegrass", ToolType.NO_TOOL,5);
        }

        if (random.nextInt(100) < 2) {
            return createCell("water");
        }

        return createResourceCell("grass", ToolType.NO_TOOL,5);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.factories.CellFactory#createSubSoil()
     */
    @Override
    public Cell createSubSoil() {
        if(random.nextInt(100)<2){
            return createResourceCell("mineral_gold", ToolType.MEDIUM_TOOL, "gold_lump");
        }
        if(random.nextInt(100)<5){
            return createResourceCell("mineral_coal", ToolType.LOW_TYPE, "coal_lump");
        }
        if(random.nextInt(100)<3){
            return createResourceCell("mineral_iron", ToolType.MEDIUM_TOOL, "iron_lump");
        }
        if(random.nextInt(100)<1){
            return createResourceCell("mineral_diamond", ToolType.HARD_TOOL, "diamond");
        }
        return createResourceCell(STONE, ToolType.LOW_TYPE,5);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.factories.CellFactory#createFirstSubSoil()
     */
    @Override
    public Cell createFirstSubSoil() {
        if(random.nextInt(100)<5){
            return createResourceCell(STONE, ToolType.LOW_TYPE,5);
        }
        return createResourceCell("dirt", ToolType.NO_TOOL,5);
    }
    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.factories.CellFactory#createTrunk()
     */
    @Override
    public Cell createTrunk() {
        return createResourceCell("tree", ToolType.NO_TOOL,4);
    }

    /*
     * (non-Javadoc)
     *
     * @see fr.univartois.butinfo.r304.flatcraft.model.map.cell.factories.CellFactory#createLeaves()
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
        if (name.startsWith("mineral")){
            sprite = sprite.mergeSprite(spriteStore.getSprite(STONE));
        }
        return new CellGrid(new Resource(name, tool, hardness, new OnMapState(sprite)));
    }
    private Cell createResourceCell(String name, ToolType tool, String nextName) {
        Sprite sprite = spriteStore.getSprite(name);
        if (name.startsWith("mineral")){
            sprite = sprite.mergeSprite(spriteStore.getSprite(STONE));
        }
        Sprite nextSprite = spriteStore.getSprite(nextName);
        return new CellGrid(new Resource(name, tool, 5, new OnMapState(sprite, nextSprite)));
    }

    public static OverworldCellFactory getInstance() {
        return instance;
    }
}
