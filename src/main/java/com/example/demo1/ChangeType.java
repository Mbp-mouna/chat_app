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
import jakarta.servlet.http.HttpSession;

import java.io.IOException;



@WebServlet("/changeUserType")
public class ChangeType  extends HttpServlet {
    private UserDao userDao;

    public void init() {
        userDao = new UserDao();
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("admin.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {

        String username = request.getParameter("username");
        String userType = request.getParameter("usertype");

        User user = userDao.getUserByUsername(username);

        if (user != null) {

            Permission newPermission = Permission.valueOf(userType);
            user.setPermission(newPermission);
            userDao.updateUser(user);
            request.setAttribute("message", "Type d'utilisateur modifié avec succès");
        } else {
            request.setAttribute("message", "Utilisateur non trouvé");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("admin.jsp");
        dispatcher.include(request, response);
    }
}









