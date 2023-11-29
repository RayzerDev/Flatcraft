package fr.univartois.butinfo.r304.flatcraft.model.resources.location;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public interface LocationState {
    Sprite getSprite();
    LocationState nextState();
    void setSprite(Sprite sprite);
}
