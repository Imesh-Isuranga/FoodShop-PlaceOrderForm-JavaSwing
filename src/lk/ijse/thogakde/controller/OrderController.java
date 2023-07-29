package lk.ijse.thogakde.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import lk.ijse.thogakde.db.DBConnection;

public class OrderController {
    public static String getOrderId() throws ClassNotFoundException, SQLException{
        Connection connection = DBConnection.getInstance().getConnection();
        String SQL = "SELECT * FROM ORDERS ORDER BY id DESC LIMIT 1";
        PreparedStatement stm = connection.prepareStatement(SQL);
        ResultSet rst = stm.executeQuery();
        if(rst.next()){ 
            String orderID = rst.getString(1);
            orderID = orderID.split("[A-Z]")[1];
            return "D-"+(Integer.parseInt(orderID)+1);
        }
        return "D-001";
    }
}
