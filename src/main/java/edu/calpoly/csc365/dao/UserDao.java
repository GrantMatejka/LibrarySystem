package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.User;

public interface UserDao extends Dao<User> {
    public Boolean authenticate(String name);
}