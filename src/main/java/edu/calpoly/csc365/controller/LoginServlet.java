package edu.calpoly.csc365.controller;

import edu.calpoly.csc365.dao.*;
import edu.calpoly.csc365.entity.*;
import edu.calpoly.csc365.service.AuthenticationService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private DaoManager dm = null;
    private AuthenticationService authenticationService = null;

    public LoginServlet() throws Exception {
        dm = DaoManagerFactory.createDaoManager();
        authenticationService = new AuthenticationService(dm.getUserDao2());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        if (authenticationService.authenticate(name)) {

            Cookie loginCookie = AuthenticationService.createLoginCookie(name);
            response.addCookie(loginCookie);

            String permission = authenticationService.GetPermission(name);

            Cookie nameCookie = authenticationService.createNameCookie(name);
            response.addCookie(nameCookie);

            Cookie idCookie = authenticationService.createIdCookie(name);
            response.addCookie(idCookie);

            if (permission.equals("MAN")) {
                response.sendRedirect("manager");

            } else if (permission.equals("LIB")) {
                response.sendRedirect("librarian");

            } else if (permission.equals("UG") || permission.equals("GR")) {
                response.sendRedirect("search");

            } else {
                response.sendRedirect("users");
            }
        } else {
            response.sendRedirect("./");
        }
    }

}