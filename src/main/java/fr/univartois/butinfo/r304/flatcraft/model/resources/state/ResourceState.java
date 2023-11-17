package fr.univartois.butinfo.r304.flatcraft.model.resources.state;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public interface ResourceState {
    Sprite getSprite();
    ResourceState nextState();
}
