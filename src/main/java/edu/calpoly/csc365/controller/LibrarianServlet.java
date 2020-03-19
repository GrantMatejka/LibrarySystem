package edu.calpoly.csc365.controller;

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
import java.util.Set;

@WebServlet(name = "LibrarianServlet", urlPatterns = "/librarian")
public class LibrarianServlet extends HttpServlet {

    private DaoManager dm;
    //TODO change what dao type this is to alter the view
    private Dao<User> userDao;


    public LibrarianServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        //TODO change what dao type this is to alter the view
        userDao = dm.getUserDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HERE is where you would edit what info gets sent to the page, whatever "users" is is what gets displayed
        //TO change this create a new method in the userDao
        //A lot of our applications will be in Book implementation
        Set<User> users = userDao.getAll();
        request.getRequestDispatcher("librarian.jsp").forward(request, response);


        //TODO change this to send different data

        request.setAttribute("message", "Hello Librarian");

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String user = request.getParameter("check_in_user");
        request.setAttribute("check_in_user",user);
        System.out.println(user);
        String book = request.getParameter("check_in_book");
        request.setAttribute("check_in_book",book);
        System.out.println(user + book);

        request.getRequestDispatcher("librarian.jsp").forward(request, response);
    }
}