package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.factory.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import fr.univartois.butinfo.r304.flatcraft.model.map.elements.TerrilGenerator;
import fr.univartois.butinfo.r304.flatcraft.model.map.elements.TreeGenerator;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;


public class MyGenerateMap implements IFabricMap{
    private final int height;
    private final int width;

    private final int mapRepeat;

    private CellFactory cellFactory;


    public MyGenerateMap(int height, int width, CellFactory factory , int mapRepeat) {
        this.height = height;
        this.width = width;
        this.cellFactory = factory;
        this.mapRepeat = mapRepeat;
    }

    public void setSpriteStore(ISpriteStore spriteStore) {
        cellFactory.setSpriteStore(spriteStore);
    }

    public void setCellFactory(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    private SimpleGameMap createSimpleMap() {
        int soilHeight = height/2;
        SimpleGameMap map = new SimpleGameMap(height, width, soilHeight);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i < soilHeight) {
                    Cell cell = cellFactory.createSky();
                    map.setAt(i, j, cell);
                } else if (i == soilHeight) {
                    Cell cell = cellFactory.createSoilSurface();
                    map.setAt(i, j, cell);
                } else if (i < soilHeight + 7) {
                    Cell cell = cellFactory.createFirstSubSoil();
                    map.setAt(i, j, cell);
                }
                else {
                    Cell cell = cellFactory.createSubSoil();
                    map.setAt(i, j, cell);
                }
            }
        }
        return map;
    }
    public GameMap createMapA() {
        SimpleGameMap map = createSimpleMap();
        TerrilGenerator terrilGenerator = new TerrilGenerator(cellFactory);
        terrilGenerator.generateTerril(map,3, 8);

        TreeGenerator treeGenerator = new TreeGenerator(cellFactory);
        treeGenerator.generateTrees(map, mapRepeat*8, 4);
        return map;
    }
    @Override
    public GameMap createMapB() {
        SimpleGameMap map = createSimpleMap();

        TerrilGenerator terrilGenerator = new TerrilGenerator(cellFactory);
        terrilGenerator.generateTerril(map, 2,3);

        return map;
    }

    public GameMap createMapC() {
        SimpleGameMap map = createSimpleMap();

        TreeGenerator treeGenerator = new TreeGenerator(cellFactory);
        treeGenerator.generateTrees(map, 5, 4);

        return map;
    }


}
