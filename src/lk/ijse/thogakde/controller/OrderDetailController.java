package lk.ijse.thogakde.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.thogakde.db.DBConnection;
import lk.ijse.thogakde.model.OrderDetail;

public class OrderDetailController {
    public static boolean addOrderDetail(ArrayList<OrderDetail> orderDetails) throws ClassNotFoundException, SQLException{
        for (OrderDetail orderDetail : orderDetails) {
            boolean isAddOrderDetail = addOrderDetail(orderDetail);
            if(!isAddOrderDetail){
                return false;
            }
        }
        return true;
    }
    
    public static boolean addOrderDetail(OrderDetail orderDetail) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        PreparedStatement stm = connection.prepareStatement("INSERT INTO OrderDetail VALUES(?,?,?,?)");
        stm.setObject(1, orderDetail.getOrderId());
        stm.setObject(2, orderDetail.getItemCode());
        stm.setObject(3, orderDetail.getQTY());
        stm.setObject(4, orderDetail.getUnitPrice());
        return stm.executeUpdate()>0;
    }
}
