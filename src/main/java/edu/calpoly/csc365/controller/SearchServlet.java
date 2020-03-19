package edu.calpoly.csc365.controller;

import edu.calpoly.csc365.dao.BookDao;
import edu.calpoly.csc365.dao.DaoManagerFactory;
import edu.calpoly.csc365.dao.Dao;
import edu.calpoly.csc365.dao.DaoManager;
import edu.calpoly.csc365.entity.Book;
import edu.calpoly.csc365.entity.User;
import edu.calpoly.csc365.service.AuthenticationService;

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

@WebServlet(name = "SearchServlet", urlPatterns = "/search")
public class SearchServlet extends HttpServlet {

    private DaoManager dm;
    private BookDao bookDao;

    public SearchServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        bookDao = dm.getBookDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        request.setAttribute("message", "Hello " + cookies[2].getValue() + " ID: " + cookies[3].getValue());

        String entry = request.getParameter("entry");
        request.setAttribute("entry", entry);

        Set<Book> books = bookDao.getSearchedBooks(entry);
        request.setAttribute("books", books);

        request.getRequestDispatcher("search.jsp").forward(request, response);
    }
}
