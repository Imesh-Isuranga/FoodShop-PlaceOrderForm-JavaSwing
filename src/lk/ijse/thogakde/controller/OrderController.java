package lk.ijse.thogakde.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.thogakde.db.DBConnection;
import lk.ijse.thogakde.model.Order;

public class OrderController {
    public static String getOrderId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM Orders ORDER BY id DESC LIMIT 1";
        PreparedStatement stm = connection.prepareStatement(SQL);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){ 
            String orderID = rst.getString(1);
            orderID = orderID.split("[A-Z]")[1];
            return "D"+(Integer.parseInt(orderID)+1);
        }
        return "D-001";
    }
    
    public static boolean addOrder(Order order) throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        try{
            connection.setAutoCommit(false);
        PreparedStatement stm = connection.prepareStatement("INSERT INTO Orders VALUES(?,?,?)");
        stm.setObject(1, order.getId());
        stm.setObject(2, order.getDate());
        stm.setObject(3, order.getCusId());
        boolean isAddedOrder = stm.executeUpdate()>0;
        if(isAddedOrder){
            boolean isAddOrderDetail = OrderDetailController.addOrderDetail(order.getOrderDetail());
            if(isAddOrderDetail){
                boolean isUpdateStock = ItemController.updateStock(order.getOrderDetail());
                if(isUpdateStock){
                    connection.commit();
                    return true;
                }
            }
        }
        return false;
        }finally{
                connection.setAutoCommit(true);
        }
    }
}
