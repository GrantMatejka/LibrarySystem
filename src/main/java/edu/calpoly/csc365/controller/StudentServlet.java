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

@WebServlet(name = "StudentServlet", urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    private DaoManager dm;
    private Dao<User> userDao;

    public StudentServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        userDao = dm.getUserDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Set<User> users = userDao.getAll();
        request.setAttribute("users", users);
        request.setAttribute("message", "Hello student");
        request.getRequestDispatcher("student.jsp").forward(request, response);

    }
}