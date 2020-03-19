package edu.calpoly.csc365.controller;

import edu.calpoly.csc365.dao.DaoManagerFactory;
import edu.calpoly.csc365.dao.Dao;
import edu.calpoly.csc365.dao.DaoManager;
import edu.calpoly.csc365.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Set;

@WebServlet(name = "ManagerServlet", urlPatterns = "/manager")
public class  ManagerServlet extends HttpServlet {

    private DaoManager dm;
    //TODO change what dao type this is to alter the view
    private Dao<User> userDao;

    public ManagerServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        userDao = dm.getUserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HERE is where you would edit what info gets sent to the page, whatever "users" is is what gets displayed
        //TO change this create a new method in the userDao
        //A lot of our applications will be in Book implementation
        Set<User> users = userDao.getAll();
        request.setAttribute("users", users);
        request.setAttribute("message", "Hello manager");
        request.getRequestDispatcher("manager.jsp").forward(request, response);

    }
}