/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Database.dbconnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetcareDao {
    

    public void additem(petcare pt)  {
           try(Connection con = dbconnection.getConnection()){
           String sql = "INSERT INTO store (itemcode , name, quntity,UnitPrice) VALUES (?, ?, ?,?)";
           PreparedStatement pst = con.prepareStatement(sql);
           pst.setInt(1,pt.getcode() );
           pst.setString(2, pt.getName());
           pst.setInt(3,pt.getquntity());
           pst.setString(4,pt.getUnitPrice());
           pst.executeUpdate();
    }catch (Exception e) { e.printStackTrace(); 

    }
}
        public List<petcare> getAllitem() {
        List<petcare> list = new ArrayList<>();
        try (Connection con = dbconnection.getConnection()) {
            String sql = "SELECT * FROM store";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new petcare(
                     rs.getInt("itemcode"),
                     rs.getString("name"),
                     rs.getInt("quntity"),
                     rs.getString("UnitPrice")   
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
    
     public void deleteItem(int itemcode) {
    try (Connection con = dbconnection.getConnection()) {
        String sql = "DELETE FROM store WHERE itemcode = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, itemcode);
        pst.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}   
}