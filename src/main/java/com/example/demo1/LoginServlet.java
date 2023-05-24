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


            String username=request.getParameter("username");

            String pass=request.getParameter("password");

            if (loginDao.validate(username, pass)) {
                RequestDispatcher dispatcher = request.getRequestDispatcher("login-success.jsp");
                dispatcher.forward(request, response);
            }
        }
        }





