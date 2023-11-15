package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

import java.util.Random;

import static java.lang.Math.round;

public class MyGenarateMap implements IFabricMap{
    private int heigth;
    private int width;

    private final Random RANDOM = new Random();
    private CellFactory cellFactory;


    public MyGenarateMap(int heigth, int width, CellFactory factory) {
        this.heigth = heigth;
        this.width = width;
        this.cellFactory = factory;
    }

    public void setSpriteStore(ISpriteStore spriteStore) {
        cellFactory.setSpriteStore(spriteStore);
    }

    public void setCellFactory(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    private SimpleGameMap createSimpleMap() {
        int soilHeigth = heigth/2;
        SimpleGameMap map = new SimpleGameMap(heigth, width, soilHeigth);
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i < soilHeigth) {
                    Cell cell = cellFactory.createSky();
                    map.setAt(i, j, cell);
                } else if (i == soilHeigth) {
                    Cell cell = cellFactory.createSoilSurface();
                    map.setAt(i, j, cell);
                } else {
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
        terrilGenerator.generateTerril(map, 3);

        TreeGenerator treeGenerator = new TreeGenerator(cellFactory);
        treeGenerator.generateTrees(map, 5, 4);
        return map;
    }
    @Override
    public GameMap createMapB() {
        SimpleGameMap map = createSimpleMap();

        TerrilGenerator terrilGenerator = new TerrilGenerator(cellFactory);
        terrilGenerator.generateTerril(map, 3);

        return map;
    }

    public GameMap createMapC() {
        SimpleGameMap map = createSimpleMap();

        TreeGenerator treeGenerator = new TreeGenerator(cellFactory);
        treeGenerator.generateTrees(map, 5, 4);

        return map;
    }


}
