package lk.ijse.thogakde.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.thogakde.db.DBConnection;
import lk.ijse.thogakde.model.Item;
import lk.ijse.thogakde.model.OrderDetail;

public class ItemController {
   public static ArrayList<String> getAllItemCode() throws ClassNotFoundException, SQLException{
       Connection connection = DBConnection.getInstance().getConnection();
       PreparedStatement stm = connection.prepareStatement("SELECT * FROM Item");
       ResultSet rst = stm.executeQuery();
       
       ArrayList<String> itemCode = new ArrayList<>();
       while(rst.next()){
           itemCode.add(rst.getString(1));
       }
       return itemCode;
       
   } 

    public static boolean updateStock(ArrayList<OrderDetail> orderDetails) throws ClassNotFoundException, SQLException {
        for (OrderDetail orderDetail : orderDetails) {
            boolean isUpdateStock = updateStock(orderDetail);
            if(!isUpdateStock){
                return false;
            }
        }
        return true;
    }
    
    public static boolean updateStock(OrderDetail orderDetail) throws ClassNotFoundException, SQLException {
       Connection connection = DBConnection.getInstance().getConnection();
       PreparedStatement stm = connection.prepareStatement("UPDATE Item set qtyOnHand = qtyOnHand-? WHERE code=?");
       stm.setObject(1, orderDetail.getQTY());
       stm.setObject(2, orderDetail.getItemCode());
       return stm.executeUpdate()>0;
        
    }
   
   public Item getItem(String code) throws ClassNotFoundException, SQLException{
       Connection connection = DBConnection.getInstance().getConnection();
       PreparedStatement stm = connection.prepareStatement("SELECT * FROM Item WHERE code =?");
       stm.setObject(1, code);
       ResultSet rst = stm.executeQuery();
       if(rst.next()){
           return new Item(rst.getString(1), rst.getString(2), rst.getDouble(3), rst.getInt(4));
       }
       return null;
   }
}
