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

@WebServlet(name = "ReservationServlet", urlPatterns = "/reserve")
public class ReservationServlet extends HttpServlet {

    private DaoManager dm;

    private TransactionDao transactionDao = null;

    public ReservationServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        transactionDao = dm.getTransactionDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("checkOut.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String bookId = request.getParameter("bookId");
        String userId = request.getParameter("userId");

        transactionDao.insertReservation(bookId, Integer.parseInt(userId));

        request.getRequestDispatcher("reserve.jsp").forward(request, response);
    }


}