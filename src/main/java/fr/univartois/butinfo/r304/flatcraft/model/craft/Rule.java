package fr.univartois.butinfo.r304.flatcraft.model.craft;


public class Rule {
    private String stringRule;
    private String product;
    private int quantity;

    public void setStringRule(String stringRule) {
        this.stringRule = stringRule;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStringRule() {
        return stringRule;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getProduct() {
        return product;
    }
}

