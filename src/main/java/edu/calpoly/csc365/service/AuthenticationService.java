package edu.calpoly.csc365.service;

import edu.calpoly.csc365.dao.UserDao;
import edu.calpoly.csc365.dao.UserDaoImpl;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class AuthenticationService {
    private UserDao userDao = null;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public Boolean authenticate(String name) {
        Boolean authenticated = false;
        authenticated = userDao.authenticate(name);
        return authenticated;
    }

    public UserDao getUserDao() {
        return this.userDao;
    }

    public static Cookie getLoginCookie(HttpServletRequest request) {
        Cookie loginCookie = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("user")) {
                    loginCookie = cookie;
                    break;
                }
            }
        }
        return loginCookie;
    }

    public static Cookie createLoginCookie(String name) {
        // create cookie
        Cookie loginCookie = new Cookie("user", name);
        //setting cookie to expire in 5 mins
        loginCookie.setMaxAge(5*60);
        return loginCookie;
    }

    public Cookie createNameCookie(String name) {
        // create cookie

        Cookie nameCookie = new Cookie("name", userDao.getName(name));
        return nameCookie;
    }

    public Cookie createIdCookie(String name) {
        // create cookie
        Cookie idCookie = new Cookie("id", userDao.getId(name));
        return idCookie;
    }

    public String GetPermission(String name) {
        return userDao.GetPermission(name);
    }
}