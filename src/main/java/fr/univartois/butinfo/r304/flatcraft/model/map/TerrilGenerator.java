package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;

import java.util.Random;

public class TerrilGenerator {

    private final Random random = new Random();
    private CellFactory factory;

    public TerrilGenerator(CellFactory factory) {
        this.factory = factory;
    }

    public void generateTerril(GameMap map, int maxTerrilSize) {
        int terrilSize = random.nextInt(maxTerrilSize) + 1; // Taille du terril aléatoire
        int soilHeight = map.getSoilHeight();

        // Vérification des limites de la carte
        if (terrilSize + soilHeight >= map.getHeight()) {
            terrilSize = map.getHeight() - soilHeight - 1;
        }

        for (int i = 0; i < terrilSize; i++) {
            for (int j = 0; j < i * 2 + 1; j++) {
                Cell cell = factory.createSubSoil();
                map.setAt(soilHeight - i, j, cell);
            }
        }

    }
}
