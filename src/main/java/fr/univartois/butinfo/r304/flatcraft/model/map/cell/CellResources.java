package fr.univartois.butinfo.r304.flatcraft.model.map.cell;

import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;

public class CellResources implements CellState {
    @Override
    public void handleResources(Player player, CellGrid cell){
        player.setHorizontalSpeed(0);
        player.setVerticalSpeed(0);
        cell.dig(player);
    }
}
