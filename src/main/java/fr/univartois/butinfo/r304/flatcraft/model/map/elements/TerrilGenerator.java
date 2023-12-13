package fr.univartois.butinfo.r304.flatcraft.model.map.elements;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.factory.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;

import java.util.Random;

public class TerrilGenerator {

    private final Random random = new Random();
    
    private final CellFactory factory;

    public TerrilGenerator(CellFactory factory) {
        this.factory = factory;
    }

    public void generateTerril(GameMap map,int numberOfTerril, int maxTerrilSize) {
    	int soilHeight = map.getSoilHeight();
        for(int k = 0;k<numberOfTerril;k++){
            int startX = random.nextInt(maxTerrilSize/2, map.getWidth());
            for (int i = maxTerrilSize; i > 0; i--) {
                for (int j = 0; j < i * 2 - 1; j++) {
                    Cell cell = factory.createFirstSubSoil();
                    int x = startX + j - i + 1;
                    int y = soilHeight - maxTerrilSize + i;
                    map.setAt(y, x, cell);
                }
            }
        }
    }
}
