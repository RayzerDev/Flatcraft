package fr.univartois.butinfo.r304.flatcraft.model.map.cell.state;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellGrid;
import fr.univartois.butinfo.r304.flatcraft.model.movables.Player;

public class CellNoResources implements CellState {

    @Override
    public void handleResources(Player player, CellGrid cell) {
        player.setY(player.getY()-1);
    }
}
