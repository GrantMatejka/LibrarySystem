package edu.calpoly.csc365.controller;

import edu.calpoly.csc365.dao.BookDao;
import edu.calpoly.csc365.dao.DaoManagerFactory;
import edu.calpoly.csc365.dao.Dao;
import edu.calpoly.csc365.dao.DaoManager;
import edu.calpoly.csc365.entity.Book;
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
    private BookDao bookDao;

    public StudentServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        bookDao = dm.getBookDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Set<Book> books = bookDao.getCheckedOutBooks(Integer.parseInt(cookies[2].getValue()));

        request.setAttribute("books", books);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }
}