package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Inventory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;

public class InventoryDaoImpl implements InventoryDao {
    Connection conn = null;
    public InventoryDaoImpl(Connection conn) {this.conn = conn;}
    @Override
    public int getNextAvailabeBook(String id) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int total = 0;
        int checked = 0;
        try{
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Inventory i WHERE i.bookId = ?");
            preparedStatement.setString(1,id);
            resultSet = preparedStatement.executeQuery();
            total = resultSet.getInt("totalQuantity");
            checked = resultSet.getInt("checkedOut");
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            }catch(SQLException e){
                    e.printStackTrace();
                }
            try{
                if(preparedStatement != null)
                    preparedStatement.close();
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
        return total - checked;
    }

    @Override
    public Inventory getById(int id) {
        return null;
    }

    @Override
    public Set<Inventory> getAll() {
        return null;
    }

    @Override
    public Integer insert(Inventory obj) {
        return null;
    }

    @Override
    public Integer update(Inventory obj) {
        return null;
    }

    @Override
    public Integer delete(Inventory obj) {
        return null;
    }
}
