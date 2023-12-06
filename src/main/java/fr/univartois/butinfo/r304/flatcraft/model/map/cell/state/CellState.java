package fr.univartois.butinfo.r304.flatcraft.model.map.cell.state;

import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellGrid;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;

public interface CellState {
    void handleResources(Player player, CellGrid cell);
}
