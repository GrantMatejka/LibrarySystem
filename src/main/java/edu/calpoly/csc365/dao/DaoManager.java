package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.Book;
import edu.calpoly.csc365.entity.User;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoManager {

    protected DataSource dataSource = null;
    protected Connection conn = null;

    public DaoManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection() throws SQLException {
        if (this.conn == null) {
            this.conn = this.dataSource.getConnection();
        }
        return this.conn;
    }

    public Connection getTransConnection() throws SQLException {
        if (this.conn == null) {
            this.getConnection().setAutoCommit(false);
        }
        return this.conn;
    }

    public void close() throws SQLException {
        try
        {
            if(this.conn != null && !this.conn.isClosed())
                this.conn.close();
        }
        catch(SQLException e) { throw e; }
    }

    public Object transaction(DaoCommand command){
        try{
            this.conn.setAutoCommit(false);
            Object returnValue = command.execute(this);
            this.conn.commit();
            return returnValue;
        } catch(Exception e){
            try {
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
        return null;
    }

    public Object executeAndClose(DaoCommand command){
        try{
            return command.execute(this);
        } finally {
            try {
                this.getConnection().close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public static User verifyUser(String username, String perLevel, Connection myConn) {
        PreparedStatement s;
        int id = -1;
        try{
            s = myConn.prepareStatement("SELECT * FROM Users WHERE username = ? AND permissionLevel = ?");
            s.setString(1, username);
            s.setString(2, perLevel);

            ResultSet result = s.executeQuery();

            User u = new User();

            int i = 0;
            while(result.next()) {
                u = new User(result.getInt("id"),
                        result.getString("username"),
                        result.getString("name"),
                        result.getString("permissionLevel"));
                i++;
            }

            if(i == 1)
                return u;
            else
                return new User();

        } catch (Exception e){
            e.printStackTrace();
            return new User();
        }
    }

    public Object transactionAndClose(final DaoCommand command){
        return executeAndClose(new DaoCommand() {
            @Override
            public Object execute(DaoManager daoManager) {
                return daoManager.transaction(command);
            }
        });
    }

    public Dao<User> getUserDao() throws SQLException {
        return new UserDaoImpl(this.getConnection());
    }
    public UserDao getUserDao2() throws SQLException {
        return new UserDaoImpl(this.getConnection());
    }

    public BookDao getBookDao() throws SQLException {
        return new BookDaoImpl(this.getConnection());
    }


}