package fr.univartois.butinfo.r304.flatcraft.model.resources.state;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;

public interface ResourceState {
    void handle(Resource resource);
    ResourceState nextState();
}
