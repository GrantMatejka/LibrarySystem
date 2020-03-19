package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.User;

public interface UserDao extends Dao<User> {
    public String GetPermission(String name);
    public Boolean authenticate(String name);
    public int getIDByUsername(String username);
}