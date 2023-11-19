package fr.univartois.butinfo.r304.flatcraft.model.resources.state;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class InInventoryState implements ResourceState{

    private Sprite sprite;

    public InInventoryState(Sprite sprite){
        this.sprite = sprite;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public ResourceState nextState() {
        return this;
    }
}
