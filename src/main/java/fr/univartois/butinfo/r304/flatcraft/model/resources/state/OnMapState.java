package fr.univartois.butinfo.r304.flatcraft.model.resources.state;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;

public class OnMapState implements ResourceState {
    @Override
    public void handle(Resource resource) {

    }

    @Override
    public ResourceState nextState() {
        return new InInventoryState();
    }
}
