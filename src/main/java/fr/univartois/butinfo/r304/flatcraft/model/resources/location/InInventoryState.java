package fr.univartois.butinfo.r304.flatcraft.model.resources.location;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class InInventoryState implements LocationState {

    private Sprite sprite;

    public InInventoryState(Sprite sprite){
        this.sprite = sprite;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public LocationState nextState() {
        return this;
    }
    @Override
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
