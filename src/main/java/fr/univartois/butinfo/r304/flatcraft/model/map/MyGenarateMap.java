package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

import java.util.Random;

public class MyGenarateMap {
    private int heigth;
    private int width;

    private final Random RANDOM = new Random();
    private CellFactory factory;

    public MyGenarateMap(int heigth, int width, CellFactory factory) {
        this.heigth = heigth;
        this.width = width;
        this.factory=factory;
    }

    public void setSpriteStore(ISpriteStore spriteStore) {
        factory.setSpriteStore(spriteStore);
    }
    public GameMap createMap() {
        int soilHeigth = heigth/2;
        SimpleGameMap map = new SimpleGameMap(heigth, width, soilHeigth);
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i < soilHeigth) {
                    Cell cell = factory.createSky();
                    map.setAt(i, j, cell);
                } else if (i == soilHeigth) {
                    Cell cell = factory.createSoilSurface();
                    map.setAt(i, j, cell);
                } else {
                    Cell cell = factory.createSubSoil();
                    map.setAt(i, j, cell);
                }
            }
        }

        TerrilGenerator terrilGenerator = new TerrilGenerator(factory);
        terrilGenerator.generateTerril(map, 5);
        
        TreeGenerator treeGenerator = new TreeGenerator(factory);
	     int numberOfTrees = 2;
	     int maxTrunkHeight = 3;
	     treeGenerator.generateTrees(map, numberOfTrees, maxTrunkHeight);

        return map;
    }

}
