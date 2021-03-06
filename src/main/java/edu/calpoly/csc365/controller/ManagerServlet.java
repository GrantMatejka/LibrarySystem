package edu.calpoly.csc365.controller;

import edu.calpoly.csc365.dao.BookDao;
import edu.calpoly.csc365.dao.DaoManagerFactory;
import edu.calpoly.csc365.dao.Dao;
import edu.calpoly.csc365.dao.DaoManager;
import edu.calpoly.csc365.entity.CheckedOut;
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
import java.util.ArrayList;
import java.util.Set;

@WebServlet(name = "ManagerServlet", urlPatterns = "/manager")
public class  ManagerServlet extends HttpServlet {

    private DaoManager dm;
    //TODO change what dao type this is to alter the view
    private BookDao bookDao;

    private Dao<User> userDao;
    private Dao<CheckedOut> CheckedOutDao;

    public ManagerServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        userDao = dm.getUserDao();
        CheckedOutDao = dm  .getCheckedOutDao();
        bookDao = dm.getBookDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HERE is where you would edit what info gets sent to the page, whatever "users" is is what gets displayed
        //TO change this create a new method in the userDao
        //A lot of our applications will be in Book implementation
        ArrayList<Integer> months = bookDao.getMonthBookCount();
        request.setAttribute("months", months);
        Set<User> users = userDao.getAll();
        Set<CheckedOut> checkedOut = CheckedOutDao.getAll();
        request.setAttribute("users", users);
        request.setAttribute("books", checkedOut);
        request.setAttribute("message", "Hello manager");
        request.getRequestDispatcher("manager.jsp").forward(request, response);

    }
}