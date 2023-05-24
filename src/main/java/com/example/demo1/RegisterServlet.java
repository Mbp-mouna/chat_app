package com.example.demo1;

import dao.UserDao;
import entities.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterServlet {
    private UserDao  userDao;
    public void init() {
       userDao = new UserDao();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("index.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        String name=request.getParameter("name");
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");

        User user = new User();
        user.setName(name);
        user.setName(username);
        user.setUsername(email);
        user.setPassword(pass);
        userDao.saveUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("register-success.jsp");
        dispatcher.forward(request, response);

    }
}
