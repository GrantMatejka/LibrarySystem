package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;
import javax.servlet.http.Cookie;

public class UserDaoImpl implements UserDao {
    Connection conn = null;

    public UserDaoImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public String getName(String username) {
        String name = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            Set<User> users = unpackResultSet(resultSet);
            name = users.iterator().next().getName();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return name;
    }

    @Override
    public String getId(String username) {
        int id = 0;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            Set<User> users = unpackResultSet(resultSet);
            id = users.iterator().next().getId();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Integer.toString(id);
    }

    @Override
    public String GetPermission(String username) {
        String perm = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Users WHERE username = ?");
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            Set<User> users = unpackResultSet(resultSet);
            perm = users.iterator().next().getPermissionLevel();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return perm;
    }
    public int getIDByUsername(String username){
        int id = -1;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try{
            preparedStatement = this.conn.prepareStatement("SELECT id FROM group09.Users WHERE username = ?");
            preparedStatement.setString(1,username);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()) {
                id = resultSet.getInt("id");

            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return id;
    }

    @Override
    public Boolean authenticate(String name) {
        Boolean authenticated = false;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT name FROM Users WHERE username = ?");
            preparedStatement.setString(1, name);
            resultSet = preparedStatement.executeQuery();
            if (resultSet != null && resultSet.first()) authenticated = true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return authenticated;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public Set<User> getAll() {
        Set<User> users = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            preparedStatement = this.conn.prepareStatement("SELECT * FROM Users");
            resultSet = preparedStatement.executeQuery();
            users = unpackResultSet(resultSet);
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
        return users;
    }


    @Override
    public Integer insert(User obj) {
        return null;
    }

    @Override
    public Integer update(User obj) {
        return null;
    }

    @Override
    public Integer delete(User obj) {
        return null;
    }

    private Set<User> unpackResultSet(ResultSet rs) throws SQLException {
        Set<User> users = new HashSet<User>();

        while(rs.next()) {
            User user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("name"),
                    rs.getString("permissionLevel"));
            users.add(user);
        }
        return users;
    }
}