package fr.univartois.butinfo.r304.flatcraft.model.map.cell;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;

public class CellNoResources implements CellState {

    @Override
    public void handleResources(Player player, CellGrid cell) {
        player.setY(player.getY()-1);
    }
}
