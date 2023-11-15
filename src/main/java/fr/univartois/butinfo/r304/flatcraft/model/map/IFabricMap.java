package fr.univartois.butinfo.r304.flatcraft.model.map;

import fr.univartois.butinfo.r304.flatcraft.model.GameMap;
import fr.univartois.butinfo.r304.flatcraft.view.ISpriteStore;

public interface IFabricMap {

    GameMap createMapA();

    GameMap createMapB();

    GameMap createMapC();

    void setSpriteStore(ISpriteStore spriteStore);
}
