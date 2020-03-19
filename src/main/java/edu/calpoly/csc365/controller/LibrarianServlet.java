package edu.calpoly.csc365.controller;

import edu.calpoly.csc365.dao.*;
import edu.calpoly.csc365.entity.CheckedOut;
import edu.calpoly.csc365.entity.Transaction;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Set;
import java.util.Date;

@WebServlet(name = "LibrarianServlet", urlPatterns = "/librarian")
public class LibrarianServlet extends HttpServlet {

    private DaoManager dm;
    //TODO change what dao type this is to alter the view
    private UserDao userDao;
    private BookDao bookDao;
    private InventoryDao InDao;
    private TransactionDao TransDao;



    public LibrarianServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        //TODO change what dao type this is to alter the view
        userDao = dm.getUserDao2();
        bookDao = dm.getBookDao();
        InDao = dm.getInventoryDao();
        TransDao = dm.getTransactionDao();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //HERE is where you would edit what info gets sent to the page, whatever "users" is is what gets displayed
        //TO change this create a new method in the userDao
        //A lot of our applications will be in Book implementation
        request.getRequestDispatcher("librarian.jsp").forward(request, response);


        //TODO change this to send different data

    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String check_out_user = request.getParameter("check_out_user");
        request.setAttribute("check_out_user", check_out_user);
        String check_out_book = request.getParameter("check_out_book");
        request.setAttribute("check_out_book",check_out_book);
        System.out.println(check_out_user + ' ' + check_out_book);
        if(!userDao.authenticate(check_out_user)){
            System.out.println("not valid user");
        }
        else if(bookDao.getById(check_out_book) == null){
            System.out.println("not valid book");
        }
        else{
            Date myDate = new Date();
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
            Transaction t = new Transaction(
                    check_out_book,
                    InDao.getNextAvailabeBook(check_out_book),
                    userDao.getIDByUsername(check_out_user),
                    sqlDate,
                    null,
                    false);

            TransDao.insertCheckout(check_out_book, InDao.getNextAvailabeBook(check_out_book),
                    userDao.getIDByUsername(check_out_user));
        }
        request.getRequestDispatcher("librarian.jsp").forward(request, response);
    }
}