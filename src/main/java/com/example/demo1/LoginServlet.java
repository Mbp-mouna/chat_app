package com.example.demo1;

import conn.HibernateUtil;
import dao.UserDao;
import entities.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/login")
public class LoginServlet  extends HttpServlet {
    private UserDao loginDao;
    public void init() {
        loginDao = new UserDao();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("login.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {


        try {
            authenticate(request, response);
        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    private void authenticate(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = loginDao.getUserByUsername(username);
            if (user != null && user.getPassword().equals(password)) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);

                switch (user.getPermission()) {
                    case ADMINISTRATOR:
                        response.sendRedirect("admin.jsp");
                        break;
                    case MODERATOR:
                        response.sendRedirect("moderator.jsp");
                        break;
                    case USER:
                        response.sendRedirect("chat.jsp");
                        break;
                    default:

                        response.sendRedirect("login.jsp");
                        break;
                }
            } else {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
                dispatcher.forward(request, response);
            } } catch (Exception e) {
            e.printStackTrace();
        }
    }
}






