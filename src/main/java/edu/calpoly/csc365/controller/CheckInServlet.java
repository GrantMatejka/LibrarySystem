package edu.calpoly.csc365.controller;

import edu.calpoly.csc365.dao.BookDao;
import edu.calpoly.csc365.dao.DaoManagerFactory;
import edu.calpoly.csc365.dao.Dao;
import edu.calpoly.csc365.dao.DaoManager;
import edu.calpoly.csc365.entity.Book;
import edu.calpoly.csc365.entity.User;
import edu.calpoly.csc365.service.AuthenticationService;
import edu.calpoly.csc365.dao.*;

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

@WebServlet(name = "CheckInServlet", urlPatterns = "/checkIn")
public class CheckInServlet extends HttpServlet {

    private DaoManager dm;

    private TransactionDao transactionDao = null;

    public CheckInServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        transactionDao = dm.getTransactionDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        Integer userId = 0;
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("id")) {
                userId = Integer.parseInt(cookie.getValue());
                break;
            }
        }

        String bookId = request.getParameter("bookId");
        String copyNum = request.getParameter("copyNum");

        System.out.println("Checking outttt " + bookId + " " + copyNum + " " + userId);
        transactionDao.insertCheckIn(bookId, Integer.parseInt(copyNum), userId);

        System.out.println("Checked In");

        request.getRequestDispatcher("checkIn.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.sendRedirect("search");
    }


}