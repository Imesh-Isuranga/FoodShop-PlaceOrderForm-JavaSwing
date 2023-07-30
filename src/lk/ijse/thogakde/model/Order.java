package lk.ijse.thogakde.model;

import java.util.ArrayList;

public class Order {
    String id;
    String date;
    String cusId;
    ArrayList<OrderDetail> orderDetail;
    
    public Order(String id, String date, String cusId, ArrayList<OrderDetail> orderDetail) {
        this.id = id;
        this.date = date;
        this.cusId = cusId;
        this.orderDetail = orderDetail;
    }

    public Order() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCusId() {
        return cusId;
    }

    public void setCusId(String cusId) {
        this.cusId = cusId;
    }

    public ArrayList<OrderDetail> getOrderDetail() {
        return orderDetail;
    }

    public void setOrderDetail(ArrayList<OrderDetail> orderDetail) {
        this.orderDetail = orderDetail;
    }
}
