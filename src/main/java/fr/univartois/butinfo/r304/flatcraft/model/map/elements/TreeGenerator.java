package fr.univartois.butinfo.r304.flatcraft.model.map.elements;

import java.util.Random;
import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.map.cell.factory.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;

public class TreeGenerator {

	private static final Random random = new Random();
	public static final String LEAVES = "leaves";
	private final CellFactory cellFactory;

    public TreeGenerator(CellFactory cellFactory) {
        this.cellFactory = cellFactory;
    }

    public void generateTrees(GameMap map, int numberOfTrees, int maxTrunkHeight) {
    	int soilHeight = map.getSoilHeight();

    	for (int i = 0; i < numberOfTrees; i++) {
    	    int trunkHeight = random.nextInt(2,maxTrunkHeight);
    	    int trunkStartC = random.nextInt(map.getWidth() - 1);
			while(trunkStartC<3 || trunkStartC > map.getWidth()-3 || !(cellContentThis(soilHeight,trunkStartC,"grass",map)
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

			for(int h = 0;h<=trunkHeight;h++) {
				map.setAt(trunkStartR-h-1, trunkStartC, cellFactory.createTrunk());
			}

			setAtNoContent(trunkStartR-trunkHeight,trunkStartC-1, LEAVES, map, cellFactory.createLeaves());

			setAtNoContent(trunkStartR-trunkHeight-1,trunkStartC,LEAVES, map, cellFactory.createLeaves());
			setAtNoContent(trunkStartR-trunkHeight,trunkStartC+1,LEAVES, map, cellFactory.createLeaves());

			setAtNoContent(trunkStartR-trunkHeight-1,trunkStartC-1,LEAVES, map, cellFactory.createLeaves());
			setAtNoContent(trunkStartR-trunkHeight-1,trunkStartC+1,LEAVES, map, cellFactory.createLeaves());

			setAtNoContent(trunkStartR-trunkHeight-2,trunkStartC,LEAVES, map, cellFactory.createLeaves());

			setAtNoContent(trunkStartR-trunkHeight,trunkStartC-2,LEAVES, map, cellFactory.createLeaves());
			setAtNoContent(trunkStartR-trunkHeight,trunkStartC+2,LEAVES, map, cellFactory.createLeaves());
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
