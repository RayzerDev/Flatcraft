package fr.univartois.butinfo.r304.flatcraft.model.movables;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

public class Player extends AbstractMovable{
    private IntegerProperty health, xp;
    private ObservableMap<Resource,Integer> inventory;
    /**
     * Crée une nouvelle instance de AbstractMovable.
     *
     * @param game      Le jeu dans lequel l'objet évolue.
     * @param xPosition La position en x initiale de l'objet.
     * @param yPosition La position en y initiale de l'objet.
     * @param sprite    L'instance de {@link Sprite} représentant l'objet.
     */
    public Player(FlatcraftGame game, double xPosition, double yPosition, Sprite sprite) {
        super(game, xPosition, yPosition, sprite);
        inventory = FXCollections.observableHashMap();
    }

    public int getHealth() {
        return health.get();
    }
    public IntegerProperty getHealthProperty() {
        return health;
    }
    public int getXp() {
        return xp.get();
    }
    public IntegerProperty getXpProperty() {
        return xp;
    }

    public ObservableMap<Resource, Integer> getInventory() {
        return inventory;
    }

    public void setHealth(int health) {
        this.health.set(health);
    }

    public void setXp(int xp) {
        this.xp.set(xp);
    }

    public void setInventory(ObservableMap<Resource, Integer> inventory) {
        this.inventory = inventory;
    }
    /**
    Méthode qui ajoute une ressource.
     */
    private void addInventory(Resource r){
        if(inventory.containsKey(r)){
            inventory.replace(r,inventory.get(r)+1);
        }
        else{
            inventory.put(r,1);
        }
    }
    /**
     Méthode qui supprime une ressource.
     */
    private void delInventory(Resource r){
        if(inventory.containsKey(r)) {
            if((inventory.get(r))==1){
                inventory.remove(r);
            } else{
                inventory.remove(r,1);
            }
        }
    }
}
