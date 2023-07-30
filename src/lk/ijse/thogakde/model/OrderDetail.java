package lk.ijse.thogakde.model;

public class OrderDetail {
    String orderId;
    String itemCode;
    int QTY;
    double unitPrice;

    public OrderDetail() {
    }

    public OrderDetail(String orderId, String itemCode, int QTY, double unitPrice) {
        this.orderId = orderId;
        this.itemCode = itemCode;
        this.QTY = QTY;
        this.unitPrice = unitPrice;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getItemCode() {
        return itemCode;
    }

    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    public int getQTY() {
        return QTY;
    }

    public void setQTY(int QTY) {
        this.QTY = QTY;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
}
