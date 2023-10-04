package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

public class GenerateGameMap implements CellFactory {
    int heigth;
    int width;
    int soilHeigth;
    public GenerateGameMap(int heigth, int width, int soilHeigth){
    }

    @Override
    public void setSpriteStore(ISpriteStore spriteStore) {

    }

    @Override
    public Cell createSky() {
        return null;
    }

    @Override
    public Cell createSoilSurface() {
        return null;
    }

    @Override
    public Cell createSubSoil() {
        return null;
    }

    @Override
    public Cell createTrunk() {
        return null;
    }

    @Override
    public Cell createLeaves() {
        return null;
    }
}
