package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

import java.util.Random;

import static java.lang.Math.round;

public class MyGenarateMap1 implements IFabricMap{
    private int heigth;
    private int width;

    private final Random RANDOM = new Random();
    private CellFactory factory;

    public MyGenarateMap1(int heigth, int width) {
        this.heigth = heigth;
        this.width = width;
        factory = new CellGridFactory();
    }

    public void setSpriteStore(ISpriteStore spriteStore) {
        factory.setSpriteStore(spriteStore);
    }
    public GameMap createMapA() {
        int soilHeigth = heigth/2;
        SimpleGameMap map = new SimpleGameMap(heigth, width, soilHeigth);
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i < soilHeigth) {
                    Cell cell = factory.createSky();
                    map.setAt(i, j, cell);
                } else if (i == soilHeigth) {
                    Cell cell = factory.createSoilSurface();
                    map.setAt(i, j, cell);
                } else {
                    Cell cell = factory.createSubSoil();
                    map.setAt(i, j, cell);
                }
            }
        }
        return map;
    }

    @Override
    public GameMap createMapB() {
        int MAXTAILLEARBRE = 5;
        int soilHeigth = round(heigth/2);
        SimpleGameMap map = new SimpleGameMap(heigth, width, soilHeigth);
        for (int i = 0; i < heigth; i++) {
            for (int j = 0; j < width; j++) {
                if (i < soilHeigth) {
                    Cell cell = factory.createSky();
                    map.setAt(i, j, cell);
                } else if (i == soilHeigth) {
                    Cell cell = factory.createSoilSurface();
                    map.setAt(i, j, cell);
                    if(RANDOM.nextInt(100)<30 && j > 2 && j < width-3
                            && cell.getResource().getName().equals("grass")
                            && map.getAt(i-1,j-1).getResource()==null
                            ){
                        cell = factory.createTrunk();
                        int tailleArbre = RANDOM.nextInt(2,MAXTAILLEARBRE);
                        for(int h = 0;h<=tailleArbre;h++) {
                            map.setAt(i-1-h, j, cell);
                        }
                        cell = factory.createLeaves();
                        map.setAt(i-tailleArbre,j-1,cell);
                        map.setAt(i-tailleArbre-1,j,cell);
                        map.setAt(i-tailleArbre,j+1,cell);
                    }

                }
                else {
                    Cell cell = factory.createSubSoil();
                    map.setAt(i, j, cell);
                }
            }
        }
        return map;
    }

}
