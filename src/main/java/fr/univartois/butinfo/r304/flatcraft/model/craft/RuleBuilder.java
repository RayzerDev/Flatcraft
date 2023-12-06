package fr.univartois.butinfo.r304.flatcraft.model.craft;

import fr.univartois.butinfo.r304.flatcraft.model.resources.Resource;

public class RuleBuilder implements IBuilder{

    protected Rule rule;

    public RuleBuilder() {
        this.createRule();
    }

    public void createRule() {
        rule = new Rule();
    }

    public Rule getRule() {
        return rule;
    }

    @Override
    public void buildRule(String rules) {
        rule.setRule(rules);
    }

    @Override
    public void buildProduct(String product) {
        rule.setProduct(product);
    }

    @Override
    public void buildQuantite(int quantite) {
        rule.setQuantity(quantite);
    }
}
