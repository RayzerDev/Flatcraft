package fr.univartois.butinfo.r304.flatcraft.model.craft;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;

public interface IBuilder {

    void buildRule(String rule);

    void buildProduct(String product);

    void buildQuantite(int quantite);
}
