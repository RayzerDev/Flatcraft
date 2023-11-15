package fr.univartois.butinfo.r304.flatcraft.model.map.cell;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;

public interface CellState {
    void handleRessources(Cell cell);
}
