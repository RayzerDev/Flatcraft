package fr.univartois.butinfo.r304.flatcraft.model.map;

import java.util.Random;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;

public class TreeGenerator {

    private static Random random = new Random();
    private CellFactory cellFactory;

    public TreeGenerator(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    public void generateTrees(GameMap map, int numberOfTrees, int maxTrunkHeight) {
    	int soilHeight = map.getSoilHeight();

    	for (int i = 0; i < numberOfTrees; i++) {
    	    int trunkHeight = random.nextInt(2,maxTrunkHeight);
    	    int trunkStartC = random.nextInt(map.getWidth() - 1);
			while(trunkStartC<3 || !(cellContentThis(soilHeight,trunkStartC,"grass",map)
					|| cellContentThis(soilHeight,trunkStartC,"dirt",map))
					|| cellContentThis(soilHeight-1,trunkStartC,"tree",map)
					|| cellContentThis(soilHeight-1,trunkStartC+1,"tree",map)
					|| cellContentThis(soilHeight-1,trunkStartC-1,"tree",map)
			){
				trunkStartC = random.nextInt(map.getWidth() - 1);
			}
			int trunkStartR = soilHeight;
			while(map.getAt(trunkStartR-1,trunkStartC).getResource()!=null){
				trunkStartR--;
			}
			Cell cell = cellFactory.createTrunk();
			for(int h = 0;h<=trunkHeight;h++) {
				map.setAt(trunkStartR-h-1, trunkStartC, cell);
			}
			cell = cellFactory.createLeaves();


			setAtNoContent(trunkStartR-trunkHeight,trunkStartC-1,"leaves", map, cell);

			setAtNoContent(trunkStartR-trunkHeight-1,trunkStartC,"leaves", map, cell);
			setAtNoContent(trunkStartR-trunkHeight,trunkStartC+1,"leaves", map, cell);

			setAtNoContent(trunkStartR-trunkHeight-1,trunkStartC-1,"leaves", map, cell);
			setAtNoContent(trunkStartR-trunkHeight-1,trunkStartC+1,"leaves", map, cell);

			setAtNoContent(trunkStartR-trunkHeight-2,trunkStartC,"leaves", map, cell);

			setAtNoContent(trunkStartR-trunkHeight,trunkStartC-2,"leaves", map, cell);
			setAtNoContent(trunkStartR-trunkHeight,trunkStartC+2,"leaves", map, cell);
    	}
    }
	private boolean cellContentThis(int r, int c, String nameR, GameMap map){
		return map.getAt(r,c).getResource()!=null && map.getAt(r,c).getResource().getName().equals(nameR);
	}
	private void setAtNoContent(int r, int c, String nameR, GameMap map, Cell cell){
		if(!cellContentThis(r,c,nameR,map)){
			map.setAt(r,c,cell);
		}
	}
}
