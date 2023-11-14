package com.example.entjava2me3.controller;

import com.example.entjava2me3.dao.OrderDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/pending")
public class PendingOrdersServlet extends HttpServlet {
    OrderDao orderDao;

    @Override
    public void init() throws ServletException {
        super.init();
        orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("orders", orderDao.getAllOrders(true));
        getServletContext().getRequestDispatcher("/WEB-INF/pending.jsp").forward(req, resp);
    }
}
