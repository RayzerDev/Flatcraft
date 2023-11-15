package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;

import java.util.Random;

public class TerrilGenerator {

    private Random random = new Random();
    
    private CellFactory factory;

    public TerrilGenerator(CellFactory factory) {
        this.factory = factory;
    }

    public void generateTerril(GameMap map, int maxTerrilSize) {
    	int soilHeight = map.getSoilHeight();
        int startX = random.nextInt(maxTerrilSize/2, map.getWidth());
        for (int i = maxTerrilSize; i > 0; i--) {
            for (int j = 0; j < i * 2 - 1; j++) {
                Cell cell = factory.createSubSoil();
                int x = startX + j - i + 1;
                int y = soilHeight - maxTerrilSize + i;
                map.setAt(y, x, cell);
            }
        }
    }
}
