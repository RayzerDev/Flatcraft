package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class CellGridFactory implements CellFactory {

    @Override
    public Cell createEmptyCell(int row, int column, Sprite sprite) {
        CellGrid cellGrid = new CellGrid(row, column);
        cellGrid = new CellGrid(sprite);
        return cellGrid;
    }

    @Override
    public Cell createResourceCell(int row, int column, Sprite sprite, Resource resource) {
        CellGrid cellGrid = new CellGrid(row, column);
        cellGrid = new CellGrid(sprite);
        cellGrid = new CellGrid(resource);
        return cellGrid;
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
