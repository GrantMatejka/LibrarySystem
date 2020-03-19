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

@WebServlet(name = "CheckOutServlet", urlPatterns = "/checkOut")
public class CheckOutServlet extends HttpServlet {

    private DaoManager dm;

    private TransactionDao transactionDao = null;

    public CheckOutServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        transactionDao = dm.getTransactionDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        System.out.println(cookies[0].getValue() + " " + cookies[1].getValue() + " " + cookies[2].getValue() + " " + cookies[3].getValue());

        String bookId = request.getParameter("bookId");
        String copyNum = request.getParameter("copyNum");
        String userId = cookies[2].getValue();

        System.out.println("Checking outttt " + bookId + " " + copyNum + " " + userId);
        transactionDao.insertCheckout(bookId, Integer.parseInt(copyNum), Integer.parseInt(userId));

        System.out.println("Checked out");

        request.getRequestDispatcher("checkOut.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.sendRedirect("search");
    }


}