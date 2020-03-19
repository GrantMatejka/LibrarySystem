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
        String entry = request.getParameter("entry");
        request.setAttribute("entry", entry);

        if (entry != null) {
            Set<Book> books = bookDao.getSearchedBooks(entry);
            System.out.println("Received: " + entry);
            if (books.size() > 0) {
                PrintWriter out = response.getWriter();

                out.println("<html><head><link rel=\"stylesheet\" href=\"css/bootstrap.min.css\">" +
                        "    <script src=\"js/bootstrap.min.js\"></script><title>Customers</title>" +
                        "    <style>table {font-family: arial, sans-serif;border-collapse: collapse;width: 100%;" +
                        "        }td, th {border: 1px solid #dddddd;text-align: left;padding: 8px;" +
                        "        }tr:nth-child(even) {background-color: #dddddd;" +
                        "        }</style></head><body>");
                out.println("<div class=\"col-2\"></div><div class=\"col\"><p><a href=\"./search.jsp\" class=\"btn btn-primary\"><- back</a></p><table><thead>Search Results</thead><tr> <th>title</th><th>author</th><th>category</th><th>Copy num</th></tr>");

                for (Book book : books) {
                    out.println("<tr><td>" + book.getTitle() + "</td><td>" + book.getAuthor() + "</td><td>" + book.getCategory() + "</td><td>" + book.getCopyNum() + "</td></tr>");
                }
                out.println("</table><p><a href=\"./search.jsp\" class=\"btn btn-primary\"><- back</a></p></div><div class=\"col-2\"></div>");
                out.close();
            }

        }
    }
}
