package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Transaction;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class TransactionDaoImpl implements TransactionDao {

    Connection conn = null;


    public TransactionDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public Transaction getById(int id) {
        return null;
    }

    @Override
    public void insertCheckout(String bookId, int copyNum, int userId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = this.conn.prepareStatement("INSERT INTO Transactions (bookId, copyNum, userId) VALUES (?, ?, ?)");
            preparedStatement.setString(1, bookId);
            preparedStatement.setInt(2, copyNum);
            preparedStatement.setInt(3, userId);

            resultSet = preparedStatement.executeQuery();
        }

        catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void insertReservation(String bookId, int userId) {
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            preparedStatement = this.conn.prepareStatement("INSERT INTO Reservation (bookId, userId) VALUES (?, ?)");
            preparedStatement.setString(1, bookId);
            preparedStatement.setInt(2, userId);

            resultSet = preparedStatement.executeQuery();
        }

        catch (SQLException e) {
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
        return null;
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