package com.example.entjava2me3.controller;


import com.example.entjava2me3.dao.OrderDao;
import com.example.entjava2me3.models.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;

@WebServlet("/success")
public class OrderSuccessServlet extends HttpServlet {
    OrderDao orderDao;

    @Override
    public void init() throws ServletException {
        super.init();
        orderDao = new OrderDao();
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HashMap<String, Double> menu = (HashMap<String, Double>) getServletContext().getAttribute("menu");
        String name = req.getParameter("name");
        String item = req.getParameter("item");
        int quantity = Integer.parseInt(req.getParameter("qty"));
        double price = menu.get(item) * quantity;

        Order newOrder = orderDao.addOrder(name, item, quantity, price);

        req.setAttribute("message", "Order has been placed!");
        req.setAttribute("order", newOrder);

        getServletContext().getRequestDispatcher("/WEB-INF/success.jsp").forward(req, resp);
    }
}
