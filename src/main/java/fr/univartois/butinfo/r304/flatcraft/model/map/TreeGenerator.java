package fr.univartois.butinfo.r304.flatcraft.model.map;

import java.util.Random;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;

public class TreeGenerator {

    private Random random = new Random();
    private CellFactory factory;

    public TreeGenerator(CellFactory factory) {
        this.factory = factory;
    }

    public void generateTrees(GameMap map, int numberOfTrees, int maxTrunkHeight) {
    	int maxTrunkStartX = map.getWidth() - 1;
    	int soilHeight = map.getSoilHeight();

    	for (int i = 0; i < numberOfTrees; i++) {
    	    int trunkHeight = random.nextInt(maxTrunkHeight) + 1;
    	    int trunkStartX = random.nextInt(maxTrunkStartX);
    	    int baseHeight = soilHeight - trunkHeight;

    	    for (int h = 0; h < 3; h++) {
    	        for (int w = -1; w <= 1; w++) {
    	            Cell cell = factory.createLeaves();
    	            int x = trunkStartX + w;
    	            int y = baseHeight + trunkHeight + h;
    	            map.setAt(y, x, cell);
    	        }
    	    }

    	    for (int h = 0; h < trunkHeight; h++) {
    	        Cell cell = factory.createTrunk();
    	        int x = trunkStartX;
    	        int y = baseHeight + h;
    	        map.setAt(x, y, cell);
    	    }
    	}
    }
}
