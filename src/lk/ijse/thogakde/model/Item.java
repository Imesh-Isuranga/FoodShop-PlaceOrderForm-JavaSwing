package lk.ijse.thogakde.model;

public class Item {
    String code;
    String description;
    double unitPrice;
    int QTYOnHand;

    public Item() {
    }

    public Item(String code, String description, double unitPrice, int QTYOnHand) {
        this.code = code;
        this.description = description;
        this.unitPrice = unitPrice;
        this.QTYOnHand = QTYOnHand;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQTYOnHand() {
        return QTYOnHand;
    }

    public void setQTYOnHand(int QTYOnHand) {
        this.QTYOnHand = QTYOnHand;
    }
}
