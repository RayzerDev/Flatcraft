package fr.univartois.butinfo.r304.flatcraft.model.resources.state;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;

public class InInventoryState implements ResourceState{
    @Override
    public void handle(Resource resource) {
        System.out.println(resource.getName());
    }

    @Override
    public ResourceState nextState() {
        return new OnMapState();
    }
}