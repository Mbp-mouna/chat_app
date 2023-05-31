package com.example.demo1;

import dao.UserDao;
import entities.User;
import enums.Permission;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao  userDao;
    public void init() {
        userDao = new UserDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("index.jsp");}

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName=request.getParameter("firstName");
        String lastName=request.getParameter("lastName");
        String username=request.getParameter("username");
        String email=request.getParameter("email");
        String pass=request.getParameter("pass");

        User user = new User();
        user. setFirstName(firstName);
        user. setLastName(lastName);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(pass);
        user.setPermission(Permission.USER);
        user.setLastConnectionTime(LocalDateTime.now());

        userDao.saveUser(user);

        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);}

}
