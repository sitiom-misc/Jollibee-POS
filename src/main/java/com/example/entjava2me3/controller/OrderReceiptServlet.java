package com.example.entjava2me3.controller;

import com.example.entjava2me3.dao.OrderDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/print/*")
public class OrderReceiptServlet extends HttpServlet {
    OrderDao orderDao;

    @Override
    public void init() throws ServletException {
        super.init();
        orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().split("/")[1]);
        req.setAttribute("message", "Thank you for dining with us! Here is your receipt:");
        req.setAttribute("order", orderDao.getOrder(id));

        getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
    }
}
