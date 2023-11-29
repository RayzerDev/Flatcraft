package fr.univartois.butinfo.r304.flatcraft.model.craft;

public class RuleBuilder {
    private String rule;
    private String product;
    private int quantity;

    public void setRule(String rule) {
        this.rule = rule;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Rule build() {
        return new Rule(rule, product, quantity);
    }
}
