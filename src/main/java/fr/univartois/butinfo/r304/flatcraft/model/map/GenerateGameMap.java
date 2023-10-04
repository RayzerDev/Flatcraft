package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.Cell;
import fr.univartois.butinfo.r304.flatcraft.model.CellFactory;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

import static java.lang.Math.round;

public class GenerateGameMap{
    int heigth;
    int width;
    int soilHeigth;
    CellFactory factory;
    ISpriteStore spriteStore;
    public GenerateGameMap(int heigth, int width, int soilHeigth){
        SimpleGameMap map = new SimpleGameMap(heigth,width,soilHeigth);
        for(int i=0;i<heigth;i++){
            for(int j=0;j<width;j++){
                if(i<soilHeigth){
                    Cell cell = factory.createSubSoil();
                    map.setAt(i,j,cell);
                } else if (i>round(heigth/1.5)) {
                    Cell cell = factory.createSky();
                    map.setAt(i,j,cell);
                }else{
                    Cell cell = factory.createSoilSurface();
                    map.setAt(i,j,cell);
                }
            }
        }
    }
}
