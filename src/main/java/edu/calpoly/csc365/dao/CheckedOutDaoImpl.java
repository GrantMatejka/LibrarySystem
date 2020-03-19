package edu.calpoly.csc365.dao;


import edu.calpoly.csc365.entity.CheckedOut;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class CheckedOutDaoImpl implements CheckedOutDao {
    Connection conn = null;
    public CheckedOutDaoImpl(Connection conn) {this.conn = conn;}

    @Override
    public CheckedOut getById(int id) {
        return null;
    }

    @Override
    public Set<CheckedOut> getAll() {
        Set<CheckedOut> checkedout = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            preparedStatement = this.conn.prepareStatement("SELECT DISTINCT * FROM (SELECT DISTINCT * FROM group09.Books b, " +
                    "group09.Inventory i WHERE b.asin = i.bookId) as a");
            resultSet = preparedStatement.executeQuery();
            checkedout = unpackResultSet(resultSet);
            
        }catch(SQLException e){
            e.printStackTrace();
        } finally{
            try {
                if (resultSet != null)
                    resultSet.close();
            }catch(SQLException e){
                e.printStackTrace();
            }try {
                if (preparedStatement != null)
                    preparedStatement.close();
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return checkedout;
    }

    private Set<CheckedOut> unpackResultSet(ResultSet rs) throws SQLException {
        Set<CheckedOut> checkedoutlist = new HashSet<CheckedOut>();
        while (rs.next()) {
            CheckedOut checkedout = new CheckedOut(
                    rs.getString("asin"),
            rs.getString("title"),
            rs.getInt("totalQuantity"),
            rs.getInt("checkedOut"));
            checkedoutlist.add(checkedout);
            System.out.println(checkedout);
        }
        return checkedoutlist;
    }

    @Override
    public Integer insert(CheckedOut obj) {
        return null;
    }

    @Override
    public Integer update(CheckedOut obj) {
        return null;
    }

    @Override
    public Integer delete(CheckedOut obj) {
        return null;
    }
}
