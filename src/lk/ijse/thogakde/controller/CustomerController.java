package lk.ijse.thogakde.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import lk.ijse.thogakde.db.DBConnection;
import lk.ijse.thogakde.model.Customer;

public class CustomerController {
   public static ArrayList<String> getAllCustomers() throws ClassNotFoundException, SQLException{
       Connection connection = DBConnection.getInstance().getConnection();
       PreparedStatement stm = connection.prepareStatement("SELECT * FROM Customer");
       ResultSet rst = stm.executeQuery();
       
       ArrayList<String> cusListId = new ArrayList<>();
       while(rst.next()){
            cusListId.add(rst.getString(1));
       }
       return cusListId;
   } 
   
   public Customer getCustomer(String id) throws ClassNotFoundException, SQLException{
       Connection connection = DBConnection.getInstance().getConnection();
       PreparedStatement stm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
       stm.setObject(1, id);
       ResultSet rst = stm.executeQuery();
       if(rst.next()){
           return new Customer(rst.getString(1),rst.getString(2), rst.getString(3), rst.getDouble(4));
       }
       return null;
   }
}
