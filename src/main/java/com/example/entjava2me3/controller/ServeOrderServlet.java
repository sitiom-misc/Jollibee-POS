package com.example.entjava2me3.controller;

import com.example.entjava2me3.dao.OrderDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/serve/*")
public class ServeOrderServlet extends HttpServlet {
    OrderDao orderDao;

    @Override
    public void init() throws ServletException {
        super.init();
        orderDao = new OrderDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getPathInfo().split("/")[1]);
        orderDao.serveOrder(id);
        resp.sendRedirect(req.getContextPath() + "/pending");
    }
}
