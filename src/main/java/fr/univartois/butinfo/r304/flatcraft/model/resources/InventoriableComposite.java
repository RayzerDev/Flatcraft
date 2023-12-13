package fr.univartois.butinfo.r304.flatcraft.model.resources;

import fr.univartois.butinfo.r304.flatcraft.view.Sprite;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;

public class InventoriableComposite implements Inventoriable{

    private final String nom;

    private final List<Inventoriable> composants;

    public InventoriableComposite(String nom) {
        this.nom = nom;
        this.composants = new ArrayList<>();
    }

    @Override
    public String getName() {
        return nom;
    }

    @Override
    public Sprite getSprite() {
        for (Inventoriable composant : composants) {
            if (composant.getSprite() != null) {
                return composant.getSprite();
            }
        }
        System.out.println("Sprite non trouvé");
        return null;
    }

    @Override
    public ToolType getToolType() {
        for (Inventoriable composant : composants) {
            if (composant.getToolType() != null) {
                return composant.getToolType();
            }
        }
        System.out.println("ToolType non trouvé");
        return null;
    }
}
