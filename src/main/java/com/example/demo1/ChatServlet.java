package com.example.demo1;

import conn.HibernateUtil;
import dao.MessageDao;
import dao.UserDao;
import entities.Message;
import entities.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/chat")
public class ChatServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private MessageDao messageDao;

    public void init() {
        messageDao = new MessageDao(HibernateUtil.getSessionFactory());
    }

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChatServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        List<Message> messages = messageDao.getAllMessages();
        request.setAttribute("messages", messages);

        request.getRequestDispatcher("chat.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String messageText = request.getParameter("message");
        Message message = new Message();
        message.setMessage(messageText);
        message.setAut(username);

        messageDao.saveMessage(message);

        response.sendRedirect("chat");
    }
}
