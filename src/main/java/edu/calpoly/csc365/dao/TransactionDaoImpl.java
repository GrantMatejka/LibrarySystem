package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Transaction;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Set;
import java.sql.Date;

public class TransactionDaoImpl implements TransactionDao {

    Connection conn = null;
    DaoManager dm = null;

    public TransactionDaoImpl(Connection conn) {
        try {
            DaoManager dm = DaoManagerFactory.createDaoManager();
        } catch (Exception e){
            System.out.println(e);
        }

        this.conn = conn;
    }

    @Override
    public Transaction getById(int id) {
        return null;
    }

    @Override
    public void checkout (String asin, int copuNumber, int userId) {
        PrepareStatement preparedStatement;
        ResultSet resultSet;

        try {
            this.dm = DaoManagerFactory.createDaoManager();
        } catch (Exception exception) {
            System.out.println("Unable to create Manager")
        }

        int time = System.currentTimeMillis();
        Java.sql.Date date_of_checkin = new java.sql.Date(time);

        try {
            preparedStatement = this.conn.prepareStatement("INSERT INTO Transactions (bookId, copyNum, userId, checkOutDate) VALUES (?, ?, ?, ?)");
            preparedStatement.setString(1, bookId);
            preparedStatement.setInt(2, copyNum);
            preparedStatement.setInt(3, userId);
            preparedStatement.setDate(4, date);
            System.out.println(preparedStatement);
            this.conn = dm.getTransConnection();
            try{
                this.conn.setAutoCommit(false);
                Object returnValue = preparedStatement.execute();
                this.conn.commit();
            } catch(Exception e){
                try {
                    this.conn.rollback();
                } catch (SQLException exception) {
                    exception.printStackTrace();
                }
            } finally {
                try {
                    this.conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
    }
    
    @Override
    public void insertReservation(String bookId, int userId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            this.dm = DaoManagerFactory.createDaoManager();
        } catch (Exception e){
            System.out.println(e);
        }

        long millis = System.currentTimeMillis();
        java.sql.Date date = new java.sql.Date(millis);

        try {
            preparedStatement = this.conn.prepareStatement("INSERT INTO Reservations (dateReserved, userId, bookId) VALUES (?, ?, ?)");
            preparedStatement.setDate(1, date);
            preparedStatement.setInt(2, userId);
            preparedStatement.setString(3, bookId);
            System.out.println(preparedStatement);
            this.conn = dm.getTransConnection();
            try{
                this.conn.setAutoCommit(false);
                Boolean returnValue = preparedStatement.execute();
                this.conn.commit();
            } catch(Exception e){
                try {
                    System.out.println(e);
                    this.conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            } finally {
                try {
                    this.conn.setAutoCommit(true);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            //boolean result = preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Set<Transaction> getAll() {
        Set<Transaction> transactions = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Transactions");
            resultSet = preparedStatement.executeQuery();
            transactions = unpackResultSet(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null)
                    resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return transactions;
    }

    @Override
    public Integer insert(Transaction obj) {

        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("INSERT INTO Transactions(bookId," +
                    "copyNum,userId,checkOutDate,expectedCheckInDate,extend) VALUES(?,?,?,?,?,?)");
            preparedStatement.setString(1, obj.getBookId());
            preparedStatement.setInt(2, obj.getCopyNum());
            preparedStatement.setDate(3, obj.getCheckOutDate());
            preparedStatement.setDate(4, obj.getExpectedCheckInDate());
            preparedStatement.setBoolean(5, obj.getExtend());
            resultSet = preparedStatement.executeQuery();


        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
        return 0;
    }

    @Override
    public Integer update(Transaction obj) {
        return null;
    }

    @Override
    public Integer delete(Transaction obj) {
        return null;
    }

    private Set<Transaction> unpackResultSet(ResultSet rs) throws SQLException {
        Set<Transaction> transactions = new HashSet<Transaction>();

        while(rs.next()) {
            Transaction transaction = new Transaction(
                    rs.getInt("id"),
                    rs.getString("bookId"),
                    rs.getInt("copyNum"),
                    rs.getInt("userId"),
                    rs.getDate("checkOutDate"),
                    rs.getDate("expectedCheckInDate"),
                    rs.getBoolean("extend"));
            transactions.add(transaction);
            System.out.println(transaction);
        }
        return transactions;
    }
}