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
            preparedStatement = this.conn.prepareStatement("SELECT DISTINCT a.asin, a.title, a.userId, a.checkOutDate, a.expectedCheckInDate FROM (SELECT DISTINCT * FROM (SELECT asin, title, copyNum FROM Books b) as b, " +
                    "(SELECT bookId, copyNum as num, userId, checkOutDate, expectedCheckInDate From Transactions t) as t WHERE DATEDIFF(t.expectedCheckInDate, SYSDATE()) < 0  AND t.bookId = b.asin AND t.num = b.copyNum) as a");
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
            rs.getInt("userId"),
            rs.getDate("checkOutDate"),
            rs.getDate("expectedCheckInDate"));
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
