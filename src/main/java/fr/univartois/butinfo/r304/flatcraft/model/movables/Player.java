package fr.univartois.butinfo.r304.flatcraft.model.movables;

import fr.univartois.butinfo.r304.flatcraft.model.FlatcraftGame;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Inventoriable;
import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;
import fr.univartois.butinfo.r304.flatcraft.view.Sprite;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableMap;

import java.util.Map;
import java.util.Optional;

public class Player extends AbstractMovable{
    private final IntegerProperty health;

    private final IntegerProperty xp;
    private ObservableMap<Inventoriable,Integer> inventory;
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
        health = new SimpleIntegerProperty(100);
        xp = new SimpleIntegerProperty();
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

    public ObservableMap<Inventoriable, Integer> getInventory() {
        return inventory;
    }

    public void setHealth(int health) {
        this.health.set(health);
    }

    public void setXp(int xp) {
        this.xp.set(xp);
    }

    public void setInventory(ObservableMap<Inventoriable, Integer> inventory) {
        this.inventory = inventory;
    }
    /**
    Méthode qui ajoute une ressource.
     */
    public void addInventory(Inventoriable r, int quantity){
        if(inventory.containsKey(r)){
            inventory.replace(r,inventory.get(r)+quantity);
        }
        else{
            inventory.put(r,quantity);
        }
    }
    /**
     Méthode qui supprime une ressource.
     */
    public void delInventory(Inventoriable r){
        if(inventory.containsKey(r)) {
            if((inventory.get(r))==1){
                inventory.remove(r);
            } else{
                inventory.replace(r, inventory.get(r) -1);
            }
        }
    }

    public Optional<Inventoriable> getResourceInventory(String nameResource){

        for (Map.Entry<Inventoriable, Integer> mapentry : inventory.entrySet()){
            if((mapentry.getKey()).getName().equals(nameResource)){
                return Optional.of(mapentry.getKey());
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
