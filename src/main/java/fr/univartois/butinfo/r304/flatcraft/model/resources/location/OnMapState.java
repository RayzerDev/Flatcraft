package fr.univartois.butinfo.r304.flatcraft.model.resources.location;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class OnMapState implements LocationState {
    private Sprite sprite, nextSprite;

    public OnMapState(Sprite sprite, Sprite nextSprite){
        this.sprite = sprite;
        this.nextSprite = nextSprite;
    }
    public OnMapState(Sprite sprite){
        this.sprite = sprite;
        this.nextSprite = null;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public LocationState nextState() {
        if(nextSprite != null){
            return new InInventoryState(nextSprite);
        }
        return new InInventoryState(sprite);
    }

    @Override
    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }
}
