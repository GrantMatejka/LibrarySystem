package edu.calpoly.csc365.dao;

import edu.calpoly.csc365.entity.User;
import javax.servlet.http.Cookie;

public interface UserDao extends Dao<User> {
    public String getName(String username);
    public String getId(String username);
    public String GetPermission(String name);
    public Boolean authenticate(String name);
<<<<<<< HEAD
    public String extendBook(String asin);
=======
    public int getIDByUsername(String username);
>>>>>>> c68b52d87b6f417e67db318381e872516d50b900
}