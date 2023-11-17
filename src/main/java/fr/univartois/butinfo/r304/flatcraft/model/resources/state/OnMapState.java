package fr.univartois.butinfo.r304.flatcraft.model.resources.state;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

public class OnMapState implements ResourceState {
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
    public ResourceState nextState() {
        if(nextSprite != null){
            return new InInventoryState(nextSprite);
        }
        return new InInventoryState(sprite);
    }
}
